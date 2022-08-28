package com.epam.spring.webprovider.service.exceptions;


import com.epam.spring.webprovider.service.model.ErrorType;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public ErrorType getErrorType(){
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
