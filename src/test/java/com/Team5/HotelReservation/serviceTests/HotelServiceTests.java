package com.Team5.HotelReservation.serviceTests;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.Team5.HotelReservation.Service.HotelRequestServiceImplementation;
import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.repository.HotelPaginatedRepository;
import com.Team5.HotelReservation.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class HotelServiceTests {

    @Mock
    private HotelPaginatedRepository hotelPaginatedRepository;

    @InjectMocks
    private HotelRequestServiceImplementation hotelRequestServiceImplementation;

    @Test
    public void testingFindPaginated(){
       Pageable paging = PageRequest.of(0,5);
       Hotel hotel = new Hotel(1L, "London House", "Illinois", "Chicago", "Valet Parking, Swimming Pool");
       List<Hotel> listOfHotels = new ArrayList<>();
       listOfHotels.add(hotel);

       Page<Hotel> hotelPagination = new PageImpl(listOfHotels);

       when(hotelPaginatedRepository.findAll(paging)).thenReturn(hotelPagination);

       Page page = hotelRequestServiceImplementation.findPaginated(0,5);

       assertThat(page.getContent().get(0)).isSameAs(hotel);
    }

}
