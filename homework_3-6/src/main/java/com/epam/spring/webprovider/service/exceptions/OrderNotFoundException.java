package com.epam.spring.webprovider.service.exceptions;

import com.epam.spring.webprovider.service.model.enums.ErrorType;

public class OrderNotFoundException extends ServiceException {

    public static final String DEFAULT_MESSAGE = "Order is not found";

    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PROCESSING_ERROR_TYPE;
    }
}
