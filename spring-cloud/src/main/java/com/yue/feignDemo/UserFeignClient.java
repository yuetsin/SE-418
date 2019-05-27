package com.yue.feignDemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sumup-microservice", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    @GetMapping("/counter/{number}/{plus}")
    String sumUp(Integer number, Integer plus);
}
