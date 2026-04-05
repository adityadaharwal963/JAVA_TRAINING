package com.rcoem.zomato_demo.repositories;

import com.rcoem.zomato_demo.entities.Customer;
import com.rcoem.zomato_demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findOneByType(String type);
}
