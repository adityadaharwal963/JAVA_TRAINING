package com.rcoem.employeemanagement.repositories;

import com.rcoem.employeemanagement.entities.EUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EUser,Long> {
    public EUser findByUsername(String username);
}
