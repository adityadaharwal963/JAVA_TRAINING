package com.rcoem.zomato_demo.services;

import com.rcoem.zomato_demo.entities.Restaurant;
import com.rcoem.zomato_demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Long addRestaurant(String restaurantName) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantName);
        return restaurantRepository.save(restaurant).getId();
    }

    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

}
