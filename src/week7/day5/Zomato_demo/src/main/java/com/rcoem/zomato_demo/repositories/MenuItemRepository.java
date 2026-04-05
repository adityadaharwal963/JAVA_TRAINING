package com.rcoem.zomato_demo.repositories;

import com.rcoem.zomato_demo.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

}
