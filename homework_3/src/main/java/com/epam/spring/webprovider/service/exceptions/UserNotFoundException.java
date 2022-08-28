package com.epam.spring.webprovider.service.exceptions;

public class UserNotFoundException extends ServiceException {

    public static final String DEFAULT_MESSAGE = "User is not found";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
