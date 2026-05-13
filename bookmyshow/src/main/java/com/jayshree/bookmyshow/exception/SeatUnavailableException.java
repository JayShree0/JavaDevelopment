package com.jayshree.bookmyshow.exception;

public class SeatUnavailableException extends RuntimeException{

    public SeatUnavailableException(String message)
    {
        super(message);
    }
}
