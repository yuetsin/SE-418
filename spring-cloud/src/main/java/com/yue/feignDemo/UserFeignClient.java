package com.yue.feignDemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    @GetMapping("/counter")
    String getCount();
}
