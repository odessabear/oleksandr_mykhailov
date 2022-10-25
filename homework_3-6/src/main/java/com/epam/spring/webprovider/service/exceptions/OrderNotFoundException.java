package com.epam.spring.webprovider.service.exceptions;

public class OrderNotFoundException extends ServiceException{

    public static final String DEFAULT_MESSAGE = "Order is not found";

    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
