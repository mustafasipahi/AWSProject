package com.advice.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException {

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, 1, "User Not Found!");
    }
}
