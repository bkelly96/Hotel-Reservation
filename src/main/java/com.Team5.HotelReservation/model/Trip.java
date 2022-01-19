package com.Team5.HotelReservation.model;


import com.Team5.HotelReservation.Service.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Trip")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Trip {


    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    private String checkIn;
    private String checkOut;
    @Enumerated(EnumType.STRING)
    private Room room = Room.Single;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expId")
    private Experience expId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "hotelId")
    private Hotel hotelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User userId;


}
