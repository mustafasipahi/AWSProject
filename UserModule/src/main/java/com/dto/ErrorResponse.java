package com.dto;

import com.advice.exception.GenericException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private Long timestamp;
    private int code;
    private String message;

    public ErrorResponse(int code, String message) {
        this.timestamp = Instant.now().toEpochMilli();
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse of(GenericException exception) {
        return new ErrorResponse(exception.getCode(), exception.getMessage());
    }

    public static ErrorResponse of(int code, String message) {
        return new ErrorResponse(code, message);
    }
}
