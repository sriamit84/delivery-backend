package com.fresure.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class BadInputException extends Exception{

    List<String> fieldNames= new ArrayList<>();

    public BadInputException(String message){
        super(message);
    }

    public BadInputException(String message, Throwable t){
        super(message,t);
    }
}
