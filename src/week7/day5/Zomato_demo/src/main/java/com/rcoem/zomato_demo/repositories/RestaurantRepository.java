package com.rcoem.zomato_demo.repositories;

import com.rcoem.zomato_demo.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
