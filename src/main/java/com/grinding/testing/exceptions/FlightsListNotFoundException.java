package com.grinding.testing.exceptions;

public class FlightsListNotFoundException extends RuntimeException {
    public FlightsListNotFoundException() {
        super("Список полетов пуст");
    }
}
