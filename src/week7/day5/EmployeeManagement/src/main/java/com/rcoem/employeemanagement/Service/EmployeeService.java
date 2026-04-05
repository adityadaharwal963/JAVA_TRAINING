package com.rcoem.employeemanagement.Service;
import com.rcoem.employeemanagement.DTO.EmployeeDTO;
import com.rcoem.employeemanagement.DTO.LoginDTO;
import com.rcoem.employeemanagement.entities.EUser;
import com.rcoem.employeemanagement.entities.Employee;
import com.rcoem.employeemanagement.exceptions.UserNotFoundException;
import com.rcoem.employeemanagement.repositories.EmployeeRepository;
import com.rcoem.employeemanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    public Boolean login(LoginDTO user) {
        EUser user1 = userRepository.findByUsername(user.getUsername());
        if (user1 == null) {
            throw new UserNotFoundException("User not found");
        }
        else return user1.getPassword().equals(user.getPassword());
    }

    public EmployeeDTO getEmployee(String username) {
        EUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setUsername(user.getUsername());
        employeeDTO.setName(user.getEmployee().getName());
        employeeDTO.setRole(user.getRole().getRole());
        employeeDTO.setSenior(user.getEmployee().getSenior());
        employeeDTO.setJuniors(user.getEmployee().getJuniors());
        return employeeDTO;
    }

    public List<EmployeeDTO> getAllJuniors(String username) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        List<Employee> employeeList = user.getEmployee().getJuniors();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setUsername(user.getUsername());
            employeeDTO.setName(user.getEmployee().getName());
            employeeDTO.setRole(user.getRole().getRole());
            employeeDTO.setSenior(user.getEmployee().getSenior());
            employeeDTO.setJuniors(user.getEmployee().getJuniors());
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }
}
