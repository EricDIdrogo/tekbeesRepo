package com.trips.tekbees.exceptions;

public class TripNotFoundException extends RuntimeException{

    public TripNotFoundException() {
        super("Trip not found");
    }

    public TripNotFoundException(String message) {
        super(message);
    }
}
