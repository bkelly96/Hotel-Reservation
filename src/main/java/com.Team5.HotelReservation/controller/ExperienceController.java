package com.Team5.HotelReservation.controller;


import com.Team5.HotelReservation.Service.ExperienceRequestService;
import com.Team5.HotelReservation.exception.ExperienceNotFoundException;
import com.Team5.HotelReservation.model.Experience;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/experience/")

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ExperienceController {

    @Autowired
    private final ExperienceRequestService requestService;

    @GetMapping("{expId}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable long expId) {
        Experience experience = requestService.getExperienceById(expId);
        if(experience == null){
            throw new ExperienceNotFoundException("Experience Not Found");
        }
        return new ResponseEntity<Experience>(experience, OK);
    }

//    @GetMapping("/{hotelId}")
//    public ResponseEntity<Experience> getExperienceByHotelId(@PathVariable long hotelId){
//
//        return new ResponseEntity<Experience>(requestService.getExperienceByHotelId(hotelId), OK);
//    }
}
