package com.Team5.HotelReservation.repository;

import com.Team5.HotelReservation.model.Experience;
import com.Team5.HotelReservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    @Query(value = "select * from experience where hotelId = ?1", nativeQuery = true)
    List<Experience> findByHotelId();

}
