package com.tp.wrc.findmyparadise.exceptions;

public class InvalidHostNameException extends Exception{

    public InvalidHostNameException( String message ){super(message);};

    public InvalidHostNameException( String message, Throwable innerException ){super(message,innerException);};

}
