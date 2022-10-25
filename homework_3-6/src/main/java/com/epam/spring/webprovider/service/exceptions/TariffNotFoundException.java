package com.epam.spring.webprovider.service.exceptions;

public class TariffNotFoundException extends ServiceException{

    public static final String DEFAULT_MESSAGE = "Tariff is not found";

    public TariffNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
