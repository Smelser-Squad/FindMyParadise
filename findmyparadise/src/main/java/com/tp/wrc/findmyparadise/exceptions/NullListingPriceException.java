package com.tp.wrc.findmyparadise.exceptions;

public class NullListingPriceException extends Exception{

    public NullListingPriceException(String message) {
        super(message);
    }

    public NullListingPriceException(String message, Throwable innerException) {
        super(message, innerException);
    }

}
