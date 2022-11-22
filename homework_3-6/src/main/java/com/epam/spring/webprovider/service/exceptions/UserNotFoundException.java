package com.epam.spring.webprovider.service.exceptions;

import com.epam.spring.webprovider.service.model.enums.ErrorType;

public class UserNotFoundException extends ServiceException {

    public static final String DEFAULT_MESSAGE = "User is not found";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
