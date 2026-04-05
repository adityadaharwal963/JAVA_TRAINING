package com.rcoem.employeemanagement.Controller;

import com.rcoem.employeemanagement.DTO.EmployeeDTO;
import com.rcoem.employeemanagement.DTO.LoginDTO;
import com.rcoem.employeemanagement.Service.EmployeeService;
import com.rcoem.employeemanagement.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO employee) {
        if(employeeService.login(employee)) {
            return "Login Success";
        }
        return "Login Failed";
    }

    @GetMapping("/view")
    public EmployeeDTO getEmployeeDetails(@RequestParam String username ) {
        EmployeeDTO emp = employeeService.getEmployee(username);
        if(emp != null) {
            throw new UserNotFoundException("User not found");
        }
        return emp;
    }

    @GetMapping("/view/juniors")
    public List<EmployeeDTO> getJuniorEmployeeDetails(@RequestParam String username ) {

        return employeeService.getAllJuniors(username);
    }
}
