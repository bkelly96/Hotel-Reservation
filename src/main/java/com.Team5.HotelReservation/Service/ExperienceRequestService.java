package com.Team5.HotelReservation.Service;

import com.Team5.HotelReservation.exception.RequestNotFoundException;
import com.Team5.HotelReservation.model.Experience;
import com.Team5.HotelReservation.repository.ExperienceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import java.util.List;

@Service
public class ExperienceRequestService {

    private final ExperienceRepository experienceRepository;


    public ExperienceRequestService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    @GetMapping
    public Experience getExperienceById(long expId){
        return experienceRepository.findById(expId).orElse(null);
    }

//    public Experience getExperienceByHotelId(long hotelId) {
//        return experienceRepository.findByHotelId(hotelId).orElseThrow(() -> new RequestNotFoundException("No Request found with is + " + hotelId));
//    }
}
