package com.rcoem.redbus.controller;

import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Passenger;
import com.rcoem.redbus.service.implementation.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passgenger")
public class PassengerController {

    @Autowired
    private PassengerServiceImpl passengerService;

    @PostMapping("/create")
    public Passenger create(@RequestBody Passenger passenger,@AuthenticationPrincipal UserDetails userDetails){
        String currentUser = userDetails.getUsername();
        return passengerService.createPassenger(passenger, currentUser);
    }

    @PostMapping("/update")
    public void update(@RequestBody Passenger passenger){
        passengerService.updatePassenger(passenger);
    }

    @GetMapping("/get/{id}")
    public Passenger get(@PathVariable Long id) {
        return passengerService.findPassengerById(id);
    }

    @GetMapping("/getAll")
    public List<Passenger> getAll(){
        return passengerService.findAll();
    }

    @GetMapping("/getAllBooking/{id}")
    public List<Booking> getAllBooking(@PathVariable Long passenger_id){
        return passengerService.findAllBookingsByPassenger(passenger_id);
    }

}
