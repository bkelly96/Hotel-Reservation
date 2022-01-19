package com.Team5.HotelReservation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPasswordOne = "password";
        String encodedPasswordOne = encoder.encode(rawPasswordOne);
        System.out.println(encodedPasswordOne);
        String rawPasswordTwo = "password";
        String encodedPasswordTwo = encoder.encode(rawPasswordTwo);
        System.out.println(encodedPasswordTwo);
        String rawPasswordThree = "password";
        String encodedPasswordThree = encoder.encode(rawPasswordTwo);
        System.out.println(encodedPasswordThree);
    }
}
