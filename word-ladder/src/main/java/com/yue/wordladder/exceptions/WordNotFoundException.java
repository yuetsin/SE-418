package com.yue.wordladder.exceptions;

public class WordNotFoundException extends RuntimeException {

    public WordNotFoundException(String message) {
        super(message);
    }
}
