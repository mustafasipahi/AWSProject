package com.advice.exception;

import org.springframework.http.HttpStatus;

public class UserDetailNotFoundException extends GenericException {

    public UserDetailNotFoundException() {
        super(HttpStatus.NOT_FOUND, 3, "User Detail Not Found!");
    }
}
