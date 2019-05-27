package com.yue.feignDemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feignDemo", configuration = FeignConfiguration.class, fallback = UserFeignImpl.class)
public interface UserFeignClient {
    @GetMapping("/addup/{number}/{plus}")
    String sumUp(@PathVariable("number") Integer number, @PathVariable("plus") Integer plus);
}
