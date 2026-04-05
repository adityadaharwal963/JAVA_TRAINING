package com.rcoem.redbus.controller;

import com.rcoem.redbus.entities.Bus;
import com.rcoem.redbus.service.implementation.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {

    @Autowired
    private BusServiceImpl busService;

    @PostMapping("/admin/buses/add")
    public Bus create(@RequestBody Bus bus) {
        return busService.create(bus);
    }

    @PostMapping("/admin/buses/update")
    public Bus update(@RequestBody Bus bus) {
        return busService.update(bus);
    }

    @GetMapping("/buses/search")
    public List<Bus> findAll() {
        return busService.findAll();
    }

    @PostMapping("/buses/search/{id}")
    public Bus find(@PathVariable Long id) {
        return busService.findById(id);
    }


}
