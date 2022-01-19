package com.Team5.HotelReservation.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String password;
    private String fName;
    private String lName;
    private String email;
    private String role;
    private boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expId")
    private List<Experience> expId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Trip> tripId;

}
