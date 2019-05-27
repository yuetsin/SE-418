package com.yue.feignDemo;

import org.springframework.stereotype.Component;

@Component
class UserFeignClientFallback implements UserFeignClient {
    @Override
    public String getCount() {
        return String.format("Yet another Successfully Trigger #%d.", GlobalCounter.triggerTick());
    }
}