package com.yue.wordladder.exceptions;

public class LadderNotFoundException extends RuntimeException {
    public LadderNotFoundException(String message) {
        super(message);
    }
}
