package com.tp.wrc.findmyparadise.exceptions;

public class NullAddressException extends Exception{

    public NullAddressException(String message) {
        super(message);
    }

    public NullAddressException(String message, Throwable innerException) {
        super(message, innerException);
    }

}
