package com.yue.wordladder.utils;

import java.util.*;

// Program to reverse an ArrayList in Java
public class Reverser
{
    public static<T> List<T> reverseList(Queue<T> list)
    {
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }
}