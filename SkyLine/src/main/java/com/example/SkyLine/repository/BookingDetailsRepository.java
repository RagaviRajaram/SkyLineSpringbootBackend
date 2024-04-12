package com.example.SkyLine.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.SkyLine.model.BookingDetails;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Integer> {
    @Query("SELECT f from BookingDetails f where f.flightNumber =:number")
    List<BookingDetails>findBookingDetails(@Param("number")String flightNumber);
}