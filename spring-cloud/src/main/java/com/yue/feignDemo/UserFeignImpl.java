package com.yue.feignDemo;

public class UserFeignImpl implements UserFeignClient {
    @Override
    public String sumUp(Integer number, Integer plus) {
        return String.format("Oh, I got it! It's %d!", number + plus);
    }
}
