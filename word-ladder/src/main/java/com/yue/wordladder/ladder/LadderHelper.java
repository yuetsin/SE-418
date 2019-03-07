package com.yue.wordladder.ladder;

public class LadderHelper {
    public static Dictionary generateDict() {
        return new Dictionary("static/dic.t");
    }

    public String[] calculateLadder(String start, String end, Dictionary dict) {
        String result[] = dict.getStringArray();
        return result;
    }
}

