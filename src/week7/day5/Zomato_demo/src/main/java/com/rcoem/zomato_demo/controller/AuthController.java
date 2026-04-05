package com.rcoem.zomato_demo.controller;

import com.rcoem.zomato_demo.dto.LoginDTO;
import com.rcoem.zomato_demo.dto.RegisterDTO;
import com.rcoem.zomato_demo.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Long> register(HttpSession httpSession,@RequestBody RegisterDTO registerDTO) {
        Long user_id = authService.register(registerDTO);
        httpSession.setAttribute("user_id", user_id);
        return ResponseEntity.ok(user_id);
    }

    @PostMapping("/login")
    public ResponseEntity<Long> login(HttpSession httpSession,@RequestBody LoginDTO loginDTO) {
        Long user_id = authService.login(loginDTO);
        httpSession.setAttribute("user_id", user_id);

        return ResponseEntity.ok(user_id);
    }

}
