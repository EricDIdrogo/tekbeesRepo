package com.trips.tekbees.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(CustomTripValidationException.class)
    public ResponseEntity<Object> handleValidationException(CustomTripValidationException ex) {
        Error error = new Error(HttpStatus.BAD_REQUEST);
        error.setMessage(ex.getMessage());
        return builResponseEntity(error);
    }

    private ResponseEntity<Object> builResponseEntity(Error error){
        return new ResponseEntity<>(error, error.getStatus());
    }
}
