package com.Team5.HotelReservation.exception;

public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(){
        super("No data found");
    }
}
