package com.Team5.HotelReservation.utils;

import com.Team5.HotelReservation.model.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelUtils {

    private static Hotel hotel;

    private static List<Hotel> hotels = new ArrayList<Hotel>(Arrays.asList(
            new Hotel(1L, "London House", "Illinois", "Chicago", "Valet Parking, Swimming Pool"),
            new Hotel(2L,"River Hotel","Illinois","Chicago","Valet Parking, Breakfast"),
            new Hotel(3l, "Hilton Chicago", "Illinois", "Chicago", "Pool, Parking, Free Wifi, Pet-Friendly, Laundry Services")
    ));
}
