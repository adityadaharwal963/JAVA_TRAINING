package com.rcoem.employeemanagement.Controller;

import com.rcoem.employeemanagement.DTO.EmployeeDTO;
import com.rcoem.employeemanagement.DTO.NewEmployeeDTO;
import com.rcoem.employeemanagement.Service.AdminService;
import com.rcoem.employeemanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public EmployeeDTO saveEmployee(@RequestBody NewEmployeeDTO employee) {
        return adminService.addEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<EmployeeDTO> getAllEmployees() {
        return adminService.getAllEmployees();
    }
}
