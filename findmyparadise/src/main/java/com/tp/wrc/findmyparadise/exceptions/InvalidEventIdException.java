package com.tp.wrc.findmyparadise.exceptions;

public class InvalidEventIdException extends Exception {

    public InvalidEventIdException(String message) {
        super(message);
    }

    public InvalidEventIdException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
