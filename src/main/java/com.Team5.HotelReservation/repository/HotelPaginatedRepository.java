package com.Team5.HotelReservation.repository;

import com.Team5.HotelReservation.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HotelPaginatedRepository extends PagingAndSortingRepository<Hotel,Long> {
    Page<Hotel> findAll(Pageable pageable);

}
