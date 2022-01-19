package com.Team5.HotelReservation.exception;

public class RequestNotFoundException extends RuntimeException{
    public RequestNotFoundException (String message){
        super(message);
    }
}
