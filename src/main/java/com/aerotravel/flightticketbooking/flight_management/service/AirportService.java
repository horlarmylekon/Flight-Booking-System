package com.aerotravel.flightticketbooking.flight_management.service;

import com.aerotravel.flightticketbooking.flight_management.model.Airport;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AirportService {
    public abstract Page<Airport> getAllAirportsPaged(int pageNum);
    public abstract List<Airport> getAllAirports();
    public abstract Airport getAirportById(Integer airportId);
    public abstract Airport saveAirport(Airport airport);
    public abstract void deleteAirport(Integer airpportId);
}
