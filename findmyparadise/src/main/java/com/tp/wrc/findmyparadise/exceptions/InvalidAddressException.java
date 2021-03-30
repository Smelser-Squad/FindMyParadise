package com.tp.wrc.findmyparadise.exceptions;

public class InvalidAddressException extends Exception{

    public InvalidAddressException(String message) {
        super(message);
    }

    public InvalidAddressException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
