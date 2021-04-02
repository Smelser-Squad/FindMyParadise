package com.tp.wrc.findmyparadise.exceptions;

public class InvalidGuestsException extends Exception {
    public InvalidGuestsException(String message){
        super(message);
    }
    public InvalidGuestsException(String message, Throwable innerException){
        super(message,innerException);
    }
}
