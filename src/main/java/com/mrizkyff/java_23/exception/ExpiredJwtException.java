package com.mrizkyff.java_23.exception;

public class ExpiredJwtException extends RuntimeException {
    public ExpiredJwtException(String exception) {
        super(exception);
    }
}
