package com.Team5.HotelReservation.repository;

import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPaginatedRepository extends PagingAndSortingRepository<User,Long> {
    Page<User> findAll(Pageable pageable);
}
