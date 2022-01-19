package com.Team5.HotelReservation;

import com.Team5.HotelReservation.Service.TripRequestService;
import com.Team5.HotelReservation.model.Trip;
import com.Team5.HotelReservation.repository.TripRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.ArrayEquals;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Team5.HotelReservation.Service.Room.Single;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TripServiceTests {

    @MockBean
    TripRepository tripRepository;

    Trip testTrip;

    @Autowired
    TripRequestService mockService;

    @BeforeEach
    void setUp(){

        testTrip = new Trip();

        testTrip.setTripId(1l);
        testTrip.setCheckIn("12/21/2012");
        testTrip.setCheckOut("12/28/2012");
        testTrip.setRoom(Single);
        testTrip.setLocation("Baltimore, Maryland");

        tripRepository.save(testTrip);

    }

    @Test
    public void testGetTripId_getsTripFromRepository() {


        when(tripRepository.findById(1l)).thenReturn(Optional.of(testTrip));

        Assertions.assertEquals(1l, mockService.getTripById(testTrip.getTripId()).getTripId());

    }
}
