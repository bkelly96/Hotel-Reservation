package com.Team5.HotelReservation.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String message){
        super(message);
    }
}
