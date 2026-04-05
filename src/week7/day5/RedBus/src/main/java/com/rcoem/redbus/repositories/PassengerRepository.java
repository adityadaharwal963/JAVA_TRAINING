package com.rcoem.redbus.repositories;

import com.rcoem.redbus.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
