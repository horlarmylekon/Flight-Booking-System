package com.aerotravel.flightticketbooking.user_management.controller;

import com.aerotravel.flightticketbooking.flight_management.service.AircraftService;
import com.aerotravel.flightticketbooking.flight_management.service.AirportService;
import com.aerotravel.flightticketbooking.flight_management.service.FlightService;
import com.aerotravel.flightticketbooking.user_management.model.Passenger;
import com.aerotravel.flightticketbooking.user_management.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class PassengerController {


    @Autowired
    AirportService airportService;
    @Autowired
    AircraftService aircraftService;
    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;

    @GetMapping("passengers")
    public String showPassengerList(@RequestParam long flightId, Model model){
        List<Passenger> passengers = flightService.getFlightById(flightId).getPassengers();
        model.addAttribute("passengers", passengers);
        model.addAttribute("flight", flightService.getFlightById(flightId));
        return "passengers";
    }
}
