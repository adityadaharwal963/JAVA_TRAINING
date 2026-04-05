package com.rcoem.zomato_demo.controller;

import com.rcoem.zomato_demo.entities.Restaurant;
import com.rcoem.zomato_demo.repositories.UserRepository;
import com.rcoem.zomato_demo.services.AuthService;
import com.rcoem.zomato_demo.services.RestaurantService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private AuthService authService;

    @PostMapping("/create")
    public ResponseEntity<Long> createRestaurant(HttpSession session, @RequestBody String restaurantName) {
       Long user_id = (Long) session.getAttribute("user_id");
       System.out.println(user_id);
       if(user_id==null || !authService.hasPermission(user_id)){
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
       return ResponseEntity.ok(restaurantService.addRestaurant(restaurantName));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Restaurant> getRestaurant(HttpSession session,@PathVariable Long id) {
        Long user_id = (Long) session.getAttribute("user_id");

        if(user_id==null || !authService.hasPermission(user_id)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(restaurantService.getRestaurant(id));
    }
}
