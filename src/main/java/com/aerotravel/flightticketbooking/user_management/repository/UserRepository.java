package com.aerotravel.flightticketbooking.user_management.repository;


import com.aerotravel.flightticketbooking.user_management.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsername(String username);

    boolean existsByUsername(String username);

}
