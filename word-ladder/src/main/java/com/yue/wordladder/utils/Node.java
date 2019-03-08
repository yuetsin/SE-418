package com.yue.wordladder.utils;

public class Node {
    public Node parent;
    public String str;
    public int level;
    public Node(Node p, String s, int l){
        parent = p;
        str = s;
        level = l;
    }
}