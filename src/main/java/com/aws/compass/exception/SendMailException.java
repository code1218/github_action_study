package com.aws.compass.exception;

public class SendMailException extends RuntimeException{
    public SendMailException(String message) {
        super(message);
    }
}
