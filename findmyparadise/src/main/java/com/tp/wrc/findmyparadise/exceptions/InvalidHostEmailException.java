package com.tp.wrc.findmyparadise.exceptions;

public class InvalidHostEmailException extends Exception {

    public InvalidHostEmailException(String message){ super (message);};

    public InvalidHostEmailException(String message, Throwable innerException){super (message, innerException);};
}
