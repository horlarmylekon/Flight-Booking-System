package com.aerotravel.flightticketbooking.flight_management.repository;

import com.aerotravel.flightticketbooking.flight_management.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
