package com.yue.feignDemo;

import java.lang.Thread;
public class GlobalCounter {
    static Long counter = 0L;
    static Long triggerTick() {
        /* Randomly sleeps for 0 to 10000 milliseconds */
        Double sleepMilliseconds = Math.random() * 10000;
        try {
            Thread.sleep(sleepMilliseconds.intValue());
            return counter++;
        } catch (Exception ex) {
            System.out.println("Interrupted");
            return -1L;
        }
    }
}

