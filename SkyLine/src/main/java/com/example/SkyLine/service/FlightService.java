package com.example.SkyLine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SkyLine.model.Flight;
import com.example.SkyLine.repository.FlightRepository;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(int id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(int id, Flight flight) {
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if (existingFlight != null) {
            flight.setId(id); // Ensure the ID is set for the updated flight
            return flightRepository.save(flight);
        } else {
            return null; // Flight not found
        }
    }

    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
}
