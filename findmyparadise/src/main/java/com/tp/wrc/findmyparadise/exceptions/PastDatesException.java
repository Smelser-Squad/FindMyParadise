package com.tp.wrc.findmyparadise.exceptions;

public class PastDatesException extends Exception{
    public PastDatesException(String message){
        super(message);
    }
    public PastDatesException(String message, Throwable innerException){
        super(message,innerException);
    }
}
