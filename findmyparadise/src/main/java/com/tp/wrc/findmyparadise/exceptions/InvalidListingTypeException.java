package com.tp.wrc.findmyparadise.exceptions;

public class InvalidListingTypeException extends Exception {

    public InvalidListingTypeException(String message) {
        super(message);
    }

    public InvalidListingTypeException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
