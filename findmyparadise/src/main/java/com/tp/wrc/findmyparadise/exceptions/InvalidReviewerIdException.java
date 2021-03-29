package com.tp.wrc.findmyparadise.exceptions;

public class InvalidReviewerIdException extends Exception {


    public InvalidReviewerIdException(String message) {
        super(message);
    }

    public InvalidReviewerIdException(String message, Throwable innerException)
    {
        super(message, innerException);
    }

}
