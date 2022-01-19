package com.Team5.HotelReservation.repositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.repository.HotelPaginatedRepository;
import com.Team5.HotelReservation.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class HotelPaginatedRepoTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private HotelPaginatedRepository hotelPaginatedRepository;

    @Test
    void findAllHotelsPaginatedTest() {
        Pageable paging = PageRequest.of(0,1);

        hotelPaginatedRepository.findAll(paging);

        Hotel hotel = new Hotel(1L, "London House", "Illinois", "Chicago", "Valet Parking, Swimming Pool");

        hotelPaginatedRepository.save(hotel);

        assertNotNull(hotel);
        assertThat(hotelPaginatedRepository.findAll(paging).getContent().get(0).getHotelId()).isEqualTo(1L);
    }
}
