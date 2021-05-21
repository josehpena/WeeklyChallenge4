package com.ifood.challenge.location;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class BadArgumentsException extends RuntimeException {

        public BadArgumentsException(String message) {
            super(message);
        }
    }

}

