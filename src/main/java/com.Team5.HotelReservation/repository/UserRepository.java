package com.Team5.HotelReservation.repository;


import com.Team5.HotelReservation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    User findByUsername (String username);
}
