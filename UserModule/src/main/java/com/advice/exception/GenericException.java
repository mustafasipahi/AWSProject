package com.advice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {

    private final int code;
    private final HttpStatus httpStatus;

    public GenericException(HttpStatus httpStatus, int code, String message) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
