package com.tp.wrc.findmyparadise.exceptions;

public class NullReservationObjectException extends Exception{
    public NullReservationObjectException(String message){
        super(message);
    }
    public NullReservationObjectException(String message, Throwable innerException){
        super(message,innerException);
    }
}
