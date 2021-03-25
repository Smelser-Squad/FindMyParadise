package com.tp.wrc.findmyparadise.exceptions;

public class NullReviewerIdException extends Exception {


    public NullReviewerIdException(String message) {
        super(message);
    }

    public NullReviewerIdException(String message, Throwable innerException)
    {
        super(message, innerException);
    }

}
