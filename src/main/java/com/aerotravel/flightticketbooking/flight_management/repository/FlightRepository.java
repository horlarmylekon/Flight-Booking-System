package com.aerotravel.flightticketbooking.flight_management.repository;

import com.aerotravel.flightticketbooking.flight_management.model.Airport;
import com.aerotravel.flightticketbooking.flight_management.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByDepartureAirportEqualsAndDestinationAirportEqualsAndDepartureDateEquals(Airport depAirport, Airport destAirport, LocalDate depDate);

}
