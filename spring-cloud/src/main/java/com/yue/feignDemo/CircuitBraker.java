package com.yue.feignDemo;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import java.util.Map;

@EnableCircuitBreaker
public class CircuitBraker {
    public Long getCount(Map<String, Object> params) {
        System.out.println(String.format("<getCount> Being called with params %s", params.toString()));
        return GlobalCounter.triggerTick();
    }
}
