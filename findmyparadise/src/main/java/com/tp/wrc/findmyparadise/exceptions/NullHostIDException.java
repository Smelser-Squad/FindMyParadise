package com.tp.wrc.findmyparadise.exceptions;

public class NullHostIDException extends Exception {

    public NullHostIDException(String message) {
        super(message);
    }

    public NullHostIDException(String message, Throwable innerException)
    {
        super(message, innerException);
    }

}
