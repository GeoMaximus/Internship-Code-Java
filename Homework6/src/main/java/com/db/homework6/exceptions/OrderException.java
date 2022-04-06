package com.db.homework6.exceptions;

public class OrderException extends Exception{
    private String message;

    public OrderException(String message) {
        this.message = message;
    }
}
