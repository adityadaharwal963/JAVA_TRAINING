package com.rcoem.employeemanagement.Service;


import com.rcoem.employeemanagement.DTO.EmployeeDTO;
import com.rcoem.employeemanagement.DTO.NewEmployeeDTO;
import com.rcoem.employeemanagement.entities.Employee;
import com.rcoem.employeemanagement.entities.Role;
import com.rcoem.employeemanagement.entities.EUser;
import com.rcoem.employeemanagement.exceptions.UserNotFoundException;
import com.rcoem.employeemanagement.repositories.EmployeeRepository;
import com.rcoem.employeemanagement.repositories.RoleRepository;
import com.rcoem.employeemanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public EmployeeDTO addEmployee(NewEmployeeDTO employee) {

        EUser user = new EUser();
        user.setUsername(employee.getUsername());
        user.setPassword(employee.getPassword());

        Employee emp = new Employee();
        emp.setName(employee.getName());
        if(employee.getSenior_id() != null){
            Employee empl = employeeRepository.findById(employee.getSenior_id()).orElse(null);
            if(empl == null){
                throw new UserNotFoundException("User not found");
            }
            emp.setSenior(empl);
        }
        employeeRepository.save(emp);

        Role role = new Role();
        System.out.println(employee.getRole());
        role.setRole(employee.getRole());
        role.setPermissions(employee.getPermissions());
        roleRepository.save(role);


        user.setEmployee(emp);
        user.setRole(role);
        user = userRepository.save(user);


        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(emp.getId());
        employeeDTO.setUsername(user.getUsername());
        employeeDTO.setName(user.getEmployee().getName());
        employeeDTO.setRole(user.getRole().getRole());
        employeeDTO.setPermission(user.getRole().getPermissions());

        return employeeDTO;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EUser> users = userRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (EUser user : users) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(user.getEmployee().getId());
            employeeDTO.setUsername(user.getUsername());
            employeeDTO.setName(user.getEmployee().getName());
            employeeDTO.setRole(user.getRole().getRole());
            employeeDTO.setPermission(user.getRole().getPermissions());
            employeeDTO.setSenior(user.getEmployee().getSenior());
            employeeDTO.setJuniors(user.getEmployee().getJuniors());
            employeeDTOS.add(employeeDTO);

        }
        return employeeDTOS;
    }
}
