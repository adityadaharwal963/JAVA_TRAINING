package com.rcoem.zomato_demo.services;

import com.rcoem.zomato_demo.dto.MenuItemDTO;
import com.rcoem.zomato_demo.entities.MenuItem;
import com.rcoem.zomato_demo.entities.Restaurant;
import com.rcoem.zomato_demo.exceptions.ResourceNotFoundException;
import com.rcoem.zomato_demo.repositories.MenuItemRepository;
import com.rcoem.zomato_demo.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuItemRepository menuItemRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<MenuItemDTO> getMenuItems(){
        List<MenuItem> menuItems = menuItemRepository.findAll();
        List<MenuItemDTO> menuItemDTOS = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            MenuItemDTO menuItemDTO = new MenuItemDTO();
            menuItemDTO.setName(menuItem.getName());
            menuItemDTO.setPrice(menuItem.getPrice());
            menuItemDTO.setDescription(menuItem.getDescription());
            menuItemDTO.setRestaurant_id(menuItem.getRestaurant().getId());
            menuItemDTOS.add(menuItemDTO);
        }
        return menuItemDTOS;
    }

    public List<MenuItemDTO> getMenuItemsByRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
        if (restaurant == null) {
            throw new ResourceNotFoundException("Restaurant not found");
        }
        List<MenuItemDTO> menuItemDTOS = new ArrayList<>();
        for(MenuItem menuItem : restaurant.getMenu()){
            MenuItemDTO menuItemDTO = new MenuItemDTO();
            menuItemDTO.setName(menuItem.getName());
            menuItemDTO.setPrice(menuItem.getPrice());
            menuItemDTO.setDescription(menuItem.getDescription());
            menuItemDTOS.add(menuItemDTO);
        }
        return menuItemDTOS;
    }

    public MenuItemDTO getMenuItemById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id).orElse(null);
        MenuItemDTO menuItemDTO = new MenuItemDTO();
        if (menuItem == null) {
            throw new ResourceNotFoundException("MenuItem not found");
        }
        menuItemDTO.setName(menuItem.getName());
        menuItemDTO.setPrice(menuItem.getPrice());
        menuItemDTO.setDescription(menuItem.getDescription());
        return menuItemDTO;
    }
    public void addMenuItem(MenuItemDTO menuItemDTO) {
        Restaurant restaurant = restaurantRepository.findById(menuItemDTO.getRestaurant_id()).orElse(null);
        if (restaurant == null) {
            throw new ResourceNotFoundException("Restaurant not found");
        }
        MenuItem menuItem = new MenuItem();
        menuItem.setName(menuItemDTO.getName());
        menuItem.setDescription(menuItemDTO.getDescription());
        menuItem.setRestaurant(restaurant);
        menuItem.setPrice(menuItem.getPrice());
        menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(MenuItemDTO menuItemDTO) {
       // to do
    }
}
