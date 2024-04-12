package com.example.SkyLine.service;
// BookingDetailsService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SkyLine.model.BookingDetails;
import com.example.SkyLine.repository.BookingDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingDetailsService {
    
    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;
    
    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsRepository.findAll();
    }
    
    public BookingDetails getBookingDetailsById(int id) {
        Optional<BookingDetails> bookingDetailsOptional = bookingDetailsRepository.findById(id);
        return bookingDetailsOptional.orElse(null);
    }
    
    public BookingDetails createBookingDetails(BookingDetails bookingDetails) {
        return bookingDetailsRepository.save(bookingDetails);
    }
    
    public void deleteBookingDetails(int id) {
        bookingDetailsRepository.deleteById(id);
    }

    public List<BookingDetails> findBookingDetailsByFlightNumber(String flightNumber) {
        return bookingDetailsRepository.findBookingDetails(flightNumber);
    }

    
}
