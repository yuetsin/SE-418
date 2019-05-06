package com.yue.wordladder.prac.exceptions;

public class LadderNotFoundException extends RuntimeException {
    public LadderNotFoundException(String message) {
        super(message);
    }
}
