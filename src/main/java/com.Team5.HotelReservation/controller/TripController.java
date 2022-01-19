package com.Team5.HotelReservation.controller;


import com.Team5.HotelReservation.Service.Room;
import com.Team5.HotelReservation.Service.TripRequestService;
import com.Team5.HotelReservation.exception.TripNotFoundException;
import com.Team5.HotelReservation.model.Trip;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Trip")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TripController {


    private final TripRequestService requestService;

    @GetMapping("{id}")
    public ResponseEntity<Trip> getAllTrips(@PathVariable long id){
        Trip trip = requestService.getTripById(id);
        if(trip == null){
            throw new TripNotFoundException("Trip Not Found");
        }
        return new ResponseEntity<Trip>(trip,OK);
    }

    @PostMapping
    public ResponseEntity createTrip(@RequestBody Trip trip){
        requestService.createTrip(trip);
        return new ResponseEntity(CREATED);
    }

    @PutMapping("/{id}/{status}")
    public ResponseEntity updateTrip(@PathVariable long id, @PathVariable Room room){
        requestService.setRoom(id, room);
        return new ResponseEntity(OK);
    }

    @DeleteMapping("/Delete/{id}")
    public void deleteTrip(@PathVariable long id){
        requestService.deleteTrip(id);
    }




}
