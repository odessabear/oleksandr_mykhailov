package com.epam.spring.webprovider.service.exceptions;

import com.epam.spring.webprovider.service.model.enums.ErrorType;

public class TariffNotFoundException extends ServiceException {

    public static final String DEFAULT_MESSAGE = "Tariff is not found";

    public TariffNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
