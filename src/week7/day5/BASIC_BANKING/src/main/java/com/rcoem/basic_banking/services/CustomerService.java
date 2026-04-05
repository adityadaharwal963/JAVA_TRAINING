package com.rcoem.basic_banking.services;

import com.rcoem.basic_banking.dto.CustomerDTO;
import com.rcoem.basic_banking.dto.CustomerQueryDTO;
import com.rcoem.basic_banking.entities.Customer;
import com.rcoem.basic_banking.exception.CustomerNotFoundException;
import com.rcoem.basic_banking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());

        customer = customerRepository.save(customer);

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setCustomerId(customer.getId());
        return customerDTO;
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());

        Customer customer1 = customerRepository.save(customer);
        if(customer1 == null){
            throw new CustomerNotFoundException("Customer not found");
        }
        customerDTO.setAddress(customer1.getAddress());
        customerDTO.setPhone(customer1.getPhone());
        customerDTO.setEmail(customer1.getEmail());
        customerDTO.setName(customer1.getName());
        customerDTO.setCustomerId(customer1.getId());
        return customerDTO;
    }

    public CustomerDTO viewAccountDetails(CustomerQueryDTO customerQueryDTO) {
        Optional<Customer> customer = customerRepository.findById(customerQueryDTO.getCustomerId());
        if(customer.isPresent()){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setName(customer.get().getName());
            customerDTO.setEmail(customer.get().getEmail());
            customerDTO.setAddress(customer.get().getAddress());
            customerDTO.setPhone(customer.get().getPhone());
            customerDTO.setCustomerId(customer.get().getId());
            customerDTO.setAccounts(customer.get().getAccounts());

            return customerDTO;
        }else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }
}
