package com.rcoem.employeemanagement.repositories;

import com.rcoem.employeemanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
