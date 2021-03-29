package com.tp.wrc.findmyparadise.exceptions;

public class InvalidReservationIdException extends Exception {
    public InvalidReservationIdException(String message){
        super(message);
    }
    public InvalidReservationIdException(String message, Throwable innerException){
        super(message,innerException);
    }
}
