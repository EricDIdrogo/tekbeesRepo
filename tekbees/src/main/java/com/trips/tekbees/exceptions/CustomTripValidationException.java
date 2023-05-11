package com.trips.tekbees.exceptions;

public class CustomTripValidationException extends RuntimeException{

    public CustomTripValidationException(String message) {
        super(message);
    }
}
