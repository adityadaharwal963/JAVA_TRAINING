package com.rcoem.redbus.repositories;

import com.rcoem.redbus.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
