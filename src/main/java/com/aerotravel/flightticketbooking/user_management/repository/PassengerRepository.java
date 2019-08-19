package com.aerotravel.flightticketbooking.user_management.repository;

import com.aerotravel.flightticketbooking.user_management.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Override
    Optional<Passenger> findById(Long id);

    Passenger findByEmail(String Email);
}
