package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.exception.RequestNotFoundException;
import com.Team5.HotelReservation.model.Trip;
import com.Team5.HotelReservation.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class TripRequestService {

    @Autowired
    private final TripRepository tripRepository;

    public Trip getTripById(long tripId) {
        return tripRepository.findById(tripId).orElse(null);
    }


    public void createTrip(Trip trip){
        tripRepository.save(trip);
    }

    public void setRoom(long id, Room room){
        tripRepository.findById(id).map(trip -> {
            trip.setRoom(room);
            return tripRepository.save(trip);
        }).orElse(null);
    }

    public void deleteTrip(long id) {
        tripRepository.deleteById(id);
    }
}
