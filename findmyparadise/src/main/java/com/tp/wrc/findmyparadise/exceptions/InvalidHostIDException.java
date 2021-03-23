package com.tp.wrc.findmyparadise.exceptions;

public class InvalidHostIDException extends Exception {

    public InvalidHostIDException(String message) {
        super(message);
    }

    public InvalidHostIDException(String message, Throwable innerException)
    {
        super(message, innerException);
    }

}
