package com2.advice.exception;

import org.springframework.http.HttpStatus;

public class UserNotActiveException extends GenericException {

    public UserNotActiveException() {
        super(HttpStatus.BAD_REQUEST, 2, "User Not Active!");
    }
}
