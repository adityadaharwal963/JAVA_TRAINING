package com.rcoem.zomato_demo.services;

import com.rcoem.zomato_demo.dto.LoginDTO;
import com.rcoem.zomato_demo.dto.RegisterDTO;
import com.rcoem.zomato_demo.entities.Customer;
import com.rcoem.zomato_demo.entities.Role;
import com.rcoem.zomato_demo.entities.AppUser;
import com.rcoem.zomato_demo.exceptions.PermissionDeniedException;
import com.rcoem.zomato_demo.exceptions.ResourceNotFoundException;
import com.rcoem.zomato_demo.repositories.RoleRepository;
import com.rcoem.zomato_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public Long register(RegisterDTO registerDTO) {
        if (registerDTO.getRole() == null || registerDTO.getRole().isEmpty()) {
            throw new IllegalArgumentException("Role type cannot be null or empty");
        }
        Role role = roleRepository.findOneByType(registerDTO.getRole()).orElse(null);
        if (role == null) {
            role = new Role();
            role.setType(registerDTO.getRole());
            role = roleRepository.save(role);
        }

        AppUser user = new AppUser();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(registerDTO.getPassword());
        user.setRole(role);
        user = userRepository.save(user);

        if(registerDTO.getRole().equals("CUSTOMER")) {
            Customer customer = new Customer();
            customer.setName(registerDTO.getName());
            customer.setUser(user);
        }
        return user.getId();
    }

    public Long login(LoginDTO loginDTO){
        AppUser user = userRepository.findByUsername(loginDTO.getUsername()).orElse(null);

        if(user == null){
            throw new ResourceNotFoundException("User not found");
        }

        if(user.getPassword().equals(loginDTO.getPassword())){
            return user.getId();
        }else {
            throw new PermissionDeniedException("Wrong password");
        }
    }

    public boolean hasPermission(Long user_id){
        AppUser user = userRepository.findById(user_id).orElse(null);

        if(user == null){
            throw new ResourceNotFoundException("User not found");
        }

        return user.getRole().getType().equals("MANAGER");
    }
}
