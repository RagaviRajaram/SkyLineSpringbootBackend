package com.example.SkyLine.controller;
import java.util.List;
// BookingDetailsController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SkyLine.model.BookingDetails;
import com.example.SkyLine.model.User;
import com.example.SkyLine.service.BookingDetailsService;
import com.example.SkyLine.service.UserService;

@RestController
@RequestMapping("/booking-details")
public class BookingDetailsController {
    
    @Autowired
    private BookingDetailsService bookingDetailsService;

    @Autowired
    private UserService userService;
    
    
    @GetMapping("/{id}")
    public BookingDetails getBookingDetailsById(@PathVariable int id) {
        return bookingDetailsService.getBookingDetailsById(id);
    }
    
    @PostMapping("/user/{userId}/create")
    public ResponseEntity<BookingDetails> createBookingDetails(@PathVariable int userId, @RequestBody BookingDetails bookingDetails) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookingDetails.setUser(user);
        BookingDetails savedBookingDetails = bookingDetailsService.createBookingDetails(bookingDetails);
        return new ResponseEntity<>(savedBookingDetails, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public void deleteBookingDetails(@PathVariable int id) {
        bookingDetailsService.deleteBookingDetails(id);
    }

    @GetMapping("/flight/{flightNumber}")
    public List<BookingDetails> findBookingDetailsByFlightNumber(@PathVariable String flightNumber) {
        return bookingDetailsService.findBookingDetailsByFlightNumber(flightNumber);
    }

    

    

    
}

