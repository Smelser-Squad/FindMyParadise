package com.tp.wrc.findmyparadise.exceptions;

public class NullListingNameException extends Exception{

    public NullListingNameException(String message) {
        super(message);
    }

    public NullListingNameException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
