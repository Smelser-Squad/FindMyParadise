package com.tp.wrc.findmyparadise.exceptions;

public class NullListingIDException extends Exception {

    public NullListingIDException(String message) {
        super(message);
    }

    public NullListingIDException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
