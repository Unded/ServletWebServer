package com.test.dao.exceptions;

public class NoSuchProductException extends Exception {
    public NoSuchProductException(String message) {
        super(message);
    }

    public NoSuchProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
