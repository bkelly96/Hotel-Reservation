package com.Team5.HotelReservation.controllerTests;


import com.Team5.HotelReservation.Service.HotelRequestServiceImplementation;
import com.Team5.HotelReservation.controller.HotelController;
import com.Team5.HotelReservation.model.Experience;
import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.model.Trip;
import com.Team5.HotelReservation.model.User;
import com.Team5.HotelReservation.utils.HotelUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class HotelControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private HotelRequestServiceImplementation hotelRequestServiceImplementation;

    public String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//
//    @Test
//    public void saveHotelTest() throws Exception {
//
//        Object experiencesObject = new Object();
//        List<Experience> listOfExperiences = new ArrayList<>();
//        List<Trip> listOfTrips = new ArrayList<>();
//        listOfExperiences.add(new Experience(1L,new User(),new Hotel(),5,"12/03/2021","Great stay",new Trip()));
//        listOfTrips.add(new Trip());
//
//        Hotel hotel = new Hotel();
//        hotel.setHotelId(1L);
//        hotel.setHotelName("London House");
//        hotel.setState("Illinois");
//        hotel.setCity("Chicago");
//        hotel.setAmenities("Valet Parking, Breakfast");
//        hotel.setExperiences(listOfExperiences);
//        hotel.setTripId(listOfTrips);
//        System.out.println(hotel);
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/hotel/createHotel")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(hotel))
//        );
//
//        verify(hotelRequestServiceImplementation,times(1)).save(any(Hotel.class));
//    }

    @Test
    public void getHotelsPaginatedTest() throws Exception {
        Pageable paging = PageRequest.of(0,5);
        Hotel hotel = new Hotel();
        hotel.setHotelId(1L);
        hotel.setHotelName("London House");
        hotel.setState("Illinois");
        hotel.setCity("Chicago");
        hotel.setAmenities("Valet Parking, Breakfast");
        System.out.println(hotel);

        List<Hotel> listOfHotels = new ArrayList<>();

        listOfHotels.add(hotel);

        Page<Hotel> page = new PageImpl<>(listOfHotels);

        when(hotelRequestServiceImplementation.findPaginated(0,1)).thenReturn(page);

        this.mockMvc.perform(get("/hotel?pageNumber=0&pageSize=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0]").value(hotel));
    }

    @Test
    public void findHotelByIdTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/hotel/10005")
                    .contentType(MediaType.APPLICATION_JSON)
        );

        verify(hotelRequestServiceImplementation,times(1)).findByIdentificationNumber(10005);
    }




}
