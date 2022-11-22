package com.epam.spring.webprovider.service.exceptions;

import com.epam.spring.webprovider.service.model.enums.ErrorType;

public class CategoryNotFoundException extends ServiceException {

    public static final String DEFAULT_MESSAGE = "Category is not found";

    public CategoryNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
