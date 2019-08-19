package com.aerotravel.flightticketbooking.core.exceptions;

public class FlightBookingException extends RuntimeException {


    String message;
    Object obj;

    public FlightBookingException() {
        super("Failed to perform the requested action");
    }

    public FlightBookingException(Throwable cause) {
        super("Failed to perform the requested action", cause);
    }

    public FlightBookingException(String message) {
        super(message);
    }

    public FlightBookingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightBookingException(String message, Object obj) {
        this.message = message;
        this.obj = obj;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
