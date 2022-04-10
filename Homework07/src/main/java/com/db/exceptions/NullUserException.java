package com.db.exceptions;

public class NullUserException extends Exception {
    String message;

    public NullUserException(String message) {
        this.message = message;
    }
}
