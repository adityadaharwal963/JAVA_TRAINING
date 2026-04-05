package com.rcoem.zomato_demo.repositories;

import com.rcoem.zomato_demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
