package com.aerotravel.flightticketbooking.flight_management.service;

import com.aerotravel.flightticketbooking.flight_management.model.Airport;
import com.aerotravel.flightticketbooking.flight_management.model.Flight;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    public abstract Page<Flight> getAllFlightsPaged(int pageNum);
    public abstract List<Flight> getAllFlights();
    public abstract Flight getFlightById(long flightId);
    public abstract Flight saveFlight(Flight flight);
    public abstract void deleteFlightById(long flightId);
    public abstract List<Flight> getAllFlightsByAirportAndDepartureTime(Airport depAirport, Airport destAirport, LocalDate depDate);
}
