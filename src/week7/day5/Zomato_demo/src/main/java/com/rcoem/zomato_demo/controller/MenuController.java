package com.rcoem.zomato_demo.controller;

import com.rcoem.zomato_demo.dto.MenuItemDTO;
import com.rcoem.zomato_demo.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-item")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/get/{id}")
    public MenuItemDTO getMenuItem(@PathVariable  Long id) {
        return menuService.getMenuItemById(id);
    }

    @GetMapping("/get")
    public List<MenuItemDTO> getMenuItems() {
        return menuService.getMenuItems();
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        menuService.addMenuItem(menuItemDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
