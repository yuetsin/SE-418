package com.yue.feignDemo;

public class Fallback implements UserFeignClient {
    @Override
    public String sumUp(Integer number, Integer plus) {
        return "Service Currently Unavailable. Try again Later.";
    }
}
