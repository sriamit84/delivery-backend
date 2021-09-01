package com.fresure.exceptions;

public class FresureException extends  Exception{

    public FresureException(String message){
        super(message);
    }

    public FresureException(String message, Throwable t){
        super(message,t);
    }
}
