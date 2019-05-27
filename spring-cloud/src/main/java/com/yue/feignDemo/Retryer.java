package com.yue.feignDemo;

public class Retryer implements feign.Retryer {
    @Override
    public feign.Retryer clone() {
        try {
            return super.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static final Retryer NEVER_RETRY = feign.Retryer();
}
