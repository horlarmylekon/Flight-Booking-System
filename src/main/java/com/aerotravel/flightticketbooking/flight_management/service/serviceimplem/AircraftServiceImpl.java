package com.aerotravel.flightticketbooking.flight_management.service.serviceimplem;

import com.aerotravel.flightticketbooking.flight_management.model.Aircraft;
import com.aerotravel.flightticketbooking.flight_management.repository.AircraftRepository;
import com.aerotravel.flightticketbooking.flight_management.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {

    private AircraftRepository aircraftRepository;

    @Autowired
    public AircraftServiceImpl(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public Page<Aircraft> getAllAircraftsPaged(int pageNum) {
        return aircraftRepository.findAll(PageRequest.of(pageNum,5,Sort.by("model")));
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft getAircraftById(Long aircraftId) {
        return aircraftRepository.findById(aircraftId).orElse(null);
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteAircraftById(Long aircraftId) {
        aircraftRepository.deleteById(aircraftId);
    }
}
