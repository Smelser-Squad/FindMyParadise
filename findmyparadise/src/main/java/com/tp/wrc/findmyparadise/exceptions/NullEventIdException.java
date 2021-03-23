package com.tp.wrc.findmyparadise.exceptions;

public class NullEventIdException extends Exception {

    public NullEventIdException(String message) {
        super(message);
    }

    public NullEventIdException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
