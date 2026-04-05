package com.rcoem.employeemanagement.repositories;

import com.rcoem.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
