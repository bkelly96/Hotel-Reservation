package com.Team5.HotelReservation.controller;


import com.Team5.HotelReservation.Service.UserRequestServiceImplementation;
import com.Team5.HotelReservation.exception.HotelNotFoundException;
import com.Team5.HotelReservation.exception.NoDataFoundException;
import com.Team5.HotelReservation.exception.UserNotFoundException;
import com.Team5.HotelReservation.model.Hotel;
import com.Team5.HotelReservation.model.User;

import static org.springframework.http.HttpStatus.*;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserRequestServiceImplementation requestService;

    public UserController(UserRequestServiceImplementation requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public Page<User> getAllHotels(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
        Page<User> user = this.requestService.findPaginated(pageNumber,pageSize);
        if(user == null){
            throw new NoDataFoundException();
        }
        return user;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = requestService.findByIdentificationNumber(id);
        if(user == null){
            throw new UserNotFoundException("User Not Found");
        }
        return new ResponseEntity<User>(user, OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User newUser) throws ServerException {
        User user = requestService.save(newUser);
        if(user == null){
            throw new ServerException("User Not Created");
        }else{
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }


    @PutMapping("/updateUser")
    public ResponseEntity<User> updateHotelById(@RequestBody User user){
        User userById = requestService.findByIdentificationNumber(21);
        HttpStatus status;
        if(userById == null){
            throw new HotelNotFoundException("Specified User Not Found");
        }else{
            userById = requestService.updateHotel(user);
            status = OK;
        }
        return new ResponseEntity<User>(userById,status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable long id){
        boolean isDeleted = requestService.deleteAsset(id);
        HttpStatus status;
        String message;
        if(isDeleted){
            status  = OK;
            message = "User Deleted Successfully";
        }else {
            status = HttpStatus.NOT_FOUND;
            message = "User with id " + id + " not found";
        }
        return new ResponseEntity<String>(message,status);
    }

}
