package com.epam.spring.webprovider.service.exceptions;

public class CategoryNotFoundException extends ServiceException{

    public static final String DEFAULT_MESSAGE = "Category is not found";

    public CategoryNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
