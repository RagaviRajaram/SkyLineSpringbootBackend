package com.example.SkyLine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.SkyLine.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    @Query("SELECT s from Flight s where s.origin =:place")
    List<Flight>findBookingDetails(@Param("place")String origin);

}
