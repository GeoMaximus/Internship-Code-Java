package com.db.exceptions;

public class UserException extends Exception {
    String message;

    public UserException(String message) {
        this.message = message;
    }
}
