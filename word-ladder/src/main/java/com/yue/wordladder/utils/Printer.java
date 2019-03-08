package com.yue.wordladder.utils;

import java.util.Queue;
import java.util.Set;

public class Printer {
    public void printQueue(Queue<String> queue) {
        if (queue.size() < 0) {
            System.out.println("=== Current Queue is ===");
            for (String q : queue) {
                System.out.print(q);
                System.out.print(" . ");
            }
            System.out.println("\n=== Queue Printing Over ===");
        }
    }

    public void printSet(Set<String> set) {
        System.out.println("=== Current Set is ===");
        for(String q : set){
            System.out.print(q);
            System.out.print(" . ");
        }
        System.out.println("\n=== Set Printing Over ===");
    }
}
