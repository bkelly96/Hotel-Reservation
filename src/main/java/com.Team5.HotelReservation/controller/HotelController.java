package com.Team5.HotelReservation.controller;

import com.Team5.HotelReservation.Service.HotelRequestServiceImplementation;
import com.Team5.HotelReservation.exception.HotelNotFoundException;
import com.Team5.HotelReservation.exception.NoDataFoundException;
import com.Team5.HotelReservation.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import com.Team5.HotelReservation.model.User;
//import jdk.jfr.internal.Repository;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelController {

    private final HotelRequestServiceImplementation requestService;

    public HotelController(HotelRequestServiceImplementation requestService) {
        this.requestService = requestService;
    }

    //    @GetMapping
//    public ResponseEntity<List<Hotel>> getAllHotels(){
//        return new ResponseEntity<List<Hotel>>(requestService.getAllHotels(), OK);
//    }


    @GetMapping
    public Page<Hotel> getAllHotels(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        Page<Hotel> hotel = this.requestService.findPaginated(pageNumber,pageSize);
        if(hotel == null){
            throw new NoDataFoundException();
        }
        return hotel;
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable long hotelId) {
        Hotel hotel = requestService.findByIdentificationNumber(hotelId);
        if(hotel == null){
            throw new HotelNotFoundException("Hotel Not Found");
        }
        return new ResponseEntity<Hotel>(hotel, OK);
    }

    @PostMapping("/createHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel newHotel) throws ServerException{
        Hotel hotel = requestService.save(newHotel);
        if(hotel == null){
            throw new ServerException("Hotel Not Created");
        }else{
            return new ResponseEntity<>(hotel, HttpStatus.CREATED);
        }
    }

    @PutMapping("/updateHotel")
    public ResponseEntity<Hotel> updateHotelById(@RequestBody Hotel hotel){
        Hotel hotelById = requestService.findByIdentificationNumber(21);
        HttpStatus status;
        if(hotelById == null){
            throw new HotelNotFoundException("Specified Hotel Not Found");
        }else{
            hotelById = requestService.updateHotel(hotel);
            status = OK;
        }
        return new ResponseEntity<Hotel>(hotelById,status);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotel(@PathVariable long hotelId){
        boolean isDeleted = requestService.deleteAsset(hotelId);
        HttpStatus status;
        String message;
        if(isDeleted){
            status  = OK;
            message = "Hotel Deleted Successfully";
        }else {
            status = HttpStatus.NOT_FOUND;
            message = "Hotel with id " + hotelId + " not found";
        }
        return new ResponseEntity<String>(message,status);
    }
}
