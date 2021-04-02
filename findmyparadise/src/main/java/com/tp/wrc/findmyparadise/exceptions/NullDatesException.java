package com.tp.wrc.findmyparadise.exceptions;

public class NullDatesException extends Exception{
    public NullDatesException(String message){
        super(message);
    }
    public NullDatesException(String message, Throwable innerException){
        super(message,innerException);
    }
}
