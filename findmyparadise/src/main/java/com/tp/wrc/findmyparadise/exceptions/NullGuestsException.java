package com.tp.wrc.findmyparadise.exceptions;

public class NullGuestsException extends Exception {
    public NullGuestsException(String message){
        super(message);
    }
    public NullGuestsException(String message, Throwable innerException){
        super(message,innerException);
    }
}
