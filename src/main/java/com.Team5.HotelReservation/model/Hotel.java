package com.Team5.HotelReservation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id //Primary Key for Unique Users
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;
    private String state;
    private String city;
    private String amenities;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "hotelId")
    private List<Experience> experiences;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "tripId")
    private List<Trip> tripId;

    public Hotel(Long hotelId, String hotelName, String state, String city, String amenities, List<Experience> experiences, List<Trip> tripId) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.state = state;
        this.city = city;
        this.amenities = amenities;
        this.experiences = experiences;
        this.tripId = tripId;
    }

    public Hotel() {}

    public Hotel(long l, String hotelName, String state, String city, String amenities) {
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Trip> getTripId() {
        return tripId;
    }

    public void setTripId(List<Trip> tripId) {
        this.tripId = tripId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(getHotelId(), hotel.getHotelId()) &&
                Objects.equals(getHotelName(), hotel.getHotelName()) &&
                Objects.equals(getState(), hotel.getState()) &&
                Objects.equals(getCity(), hotel.getCity()) &&
                Objects.equals(getAmenities(), hotel.getAmenities()) &&
                Objects.equals(getExperiences(), hotel.getExperiences()) &&
                Objects.equals(getTripId(), hotel.getTripId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotelId(), getHotelName(), getState(), getCity(), getAmenities(), getExperiences(), getTripId());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", amenities='" + amenities + '\'' +
                ", experiences=" + experiences +
                ", tripId=" + tripId +
                '}';
    }
}
