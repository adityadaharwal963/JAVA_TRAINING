package com.rcoem.basic_banking.repositories;

import com.rcoem.basic_banking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
