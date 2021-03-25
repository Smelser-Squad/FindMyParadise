package com.tp.wrc.findmyparadise.exceptions;

public class InvalidListingNameException extends Exception {


    public InvalidListingNameException(String message) {
        super(message);
    }

    public InvalidListingNameException(String message, Throwable innerException)
    {
        super(message, innerException);
    }

}
