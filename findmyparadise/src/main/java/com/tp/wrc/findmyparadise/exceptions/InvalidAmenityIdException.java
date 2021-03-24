package com.tp.wrc.findmyparadise.exceptions;

public class InvalidAmenityIdException extends Exception {

    public InvalidAmenityIdException(String message) {
        super(message);
    }

    public InvalidAmenityIdException(String message, Throwable innerException) {
        super(message, innerException);
    }

}
