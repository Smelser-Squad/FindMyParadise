package com.tp.wrc.findmyparadise.exceptions;

public class NullAmenityIdException extends Exception{

    public NullAmenityIdException(String message) {
        super(message);
    }

    public NullAmenityIdException(String message, Throwable innerException) {
        super(message, innerException);
    }

}
