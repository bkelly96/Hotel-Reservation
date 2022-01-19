package com.Team5.HotelReservation.repository;

import com.Team5.HotelReservation.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository <Trip, Long> {

}
