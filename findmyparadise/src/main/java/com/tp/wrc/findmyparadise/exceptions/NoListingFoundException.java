package com.tp.wrc.findmyparadise.exceptions;

public class NoListingFoundException extends Exception {

    public NoListingFoundException(String message) {
        super(message);
    }

    public NoListingFoundException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
