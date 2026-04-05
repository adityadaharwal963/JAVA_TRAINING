package com.rcoem.basic_banking.controller;

import com.rcoem.basic_banking.dto.CustomerDTO;
import com.rcoem.basic_banking.dto.CustomerQueryDTO;
import com.rcoem.basic_banking.entities.Customer;
import com.rcoem.basic_banking.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public CustomerDTO registerCustomer(@RequestBody CustomerDTO customer) {
        return customerService.registerCustomer(customer);
    }

    @GetMapping("/all")
    public CustomerDTO getCustomer(@RequestBody CustomerQueryDTO customerQueryDTO) {
        return customerService.viewAccountDetails(customerQueryDTO);
    }
}
