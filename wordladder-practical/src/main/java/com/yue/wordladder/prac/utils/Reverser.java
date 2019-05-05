package com.yue.wordladder.prac.utils;

import java.util.*;

// Program to reverse an ArrayList in Java
public class Reverser
{
    public static<T> List<T> reverseList(List<T> list)
    {
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }
}