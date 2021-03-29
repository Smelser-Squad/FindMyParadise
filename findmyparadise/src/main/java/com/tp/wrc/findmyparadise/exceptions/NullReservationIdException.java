package com.tp.wrc.findmyparadise.exceptions;

public class NullReservationIdException extends Exception {
    public NullReservationIdException(String message){
        super(message);
    }
    public NullReservationIdException(String message, Throwable innerException){
        super(message,innerException);
    }
}
