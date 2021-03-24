package com.tp.wrc.findmyparadise.exceptions;

public class InvalidListingIDException extends Exception {

    public InvalidListingIDException(String message) {
        super(message);
    }

    public InvalidListingIDException(String message, Throwable innerException) {
        super(message, innerException);
    }
}

