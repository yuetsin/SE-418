package com.yue.wordladder.prac.exceptions;

public class WordNotFoundException extends RuntimeException {

    public WordNotFoundException(String message) {
        super(message);
    }
}
