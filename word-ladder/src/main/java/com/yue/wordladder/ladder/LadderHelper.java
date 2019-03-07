package com.yue.wordladder.ladder;
import com.yue.wordladder.exceptions.LadderNotFoundException;
import com.yue.wordladder.exceptions.WordNotFoundException;
import com.yue.wordladder.utils.Reverser;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class LadderHelper {
    public static Dictionary generateDict() {
        return new Dictionary("static/dic.t");
    }

    public List<String> calculateLadder(String start, String end, Dictionary dict) throws WordNotFoundException, LadderNotFoundException {

        Set<String> lib = new HashSet<>(Arrays.asList(dict.getStringArray()));
        if (start == null && end == null) {
            throw new WordNotFoundException(String.format("Word %s or/and %s is/are not in my dictionary.", start, end));
        }
        if (start.length() == 0 && end.length() == 0) {
            throw new WordNotFoundException(String.format("Word %s or/and %s is/are not in my dictionary.", start, end));
        }
//        assert(start.length() == end.length());
        if (dict == null || lib.size() == 0) {
            throw new LadderNotFoundException(String.format("Failed to generate ladder from %s to %s.", start, end));
        }

        int ladderLen = 1;

        Queue<String> q = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        q.offer(start);
        hash.add(start);
        while (!q.isEmpty()) {
            ladderLen++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                String strTemp = q.poll();

                for (String nextWord : getFollowing(strTemp, lib)) {
                    if (nextWord.equals(end)) return new ArrayList(hash);
                    // filter visited word in the dict
                    if (hash.contains(nextWord)) continue;
                    q.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }

        throw new LadderNotFoundException(String.format("Failed to generate ladder from %s to %s.", start, end));
    }

    private Set<String> getFollowing(String current, Set<String> dict) {
        Set<String> nextWords = new HashSet<String>();
        String temp;
        for (int i = 0; i < current.length(); i++) {
            StringBuilder sb = new StringBuilder(current);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);

                temp = sb.toString();
                if (dict.contains(temp)) {
                    nextWords.add(temp);
                }
            }
//
//            sb = sb.deleteCharAt(i);
//
//            temp = sb.toString();
//            if (dict.contains(temp)) {
//                nextWords.add(temp);
//            }
        }
/*
        for (int i = 0; i < current.length() + 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(current);
                sb.insert(i, c);
                String temp = sb.toString();
                if (dict.contains(temp)) {
                    nextWords.add(temp);
                }
            }
        }
        */

        return nextWords;
    }
}

