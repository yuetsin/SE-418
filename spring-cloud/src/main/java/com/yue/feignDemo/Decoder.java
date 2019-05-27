package com.yue.feignDemo;

import feign.FeignException;
import org.springframework.util.StreamUtils;

import javax.xml.ws.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class Decoder {
    public Object decode(final Response response, Type type) throws IOException, FeignException {
        Response resetResponse = null;
        FeignResponseAdapter responseAdpter = new FeignResponseAdapter(response);
        if (responseAdpter.canRead()) {
            List<Charset> charsets = responseAdpter.getHeaders().getAcceptCharset();
            byte[] byBody = responseAdpter.extractData();
            String body = StreamUtils.copyToString(new ByteArrayInputStream(byBody), Charset.forName("utf-8"));
            ErrorResult errorResult = HttpErrorDecoder.decode(body);
            if (errorResult != null) {
                SecurityContext securityContext = SecurityContextHystrixRequestVariable.getInstance().get();
                if (securityContext != null) {
                    securityContext.setErrorResult(errorResult);
                }
                return null;
            } else {
                resetResponse = Response.builder().body(byBody).headers(response.headers()).status(response.status()).reason(response.reason()).request(response.request()).build();
            }
        } else {
            resetResponse = response;
        }

        if (isParameterizeHttpEntity(type)) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
            Object decodedObject = decoder.decode(resetResponse, type);

            return createResponse(decodedObject, resetResponse);
        } else if (isHttpEntity(type)) {
            return createResponse(null, resetResponse);
        } else {
            return decoder.decode(resetResponse, type);
        }
    }
}
