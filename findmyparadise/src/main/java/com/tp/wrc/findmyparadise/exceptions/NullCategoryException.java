package com.tp.wrc.findmyparadise.exceptions;

public class NullCategoryException extends Exception{
    public NullCategoryException(String message) {
        super(message);
    }

    public NullCategoryException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
