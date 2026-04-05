package com.rcoem.zomato_demo.repositories;

import com.rcoem.zomato_demo.entities.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<FoodOrder,Long> {
}
