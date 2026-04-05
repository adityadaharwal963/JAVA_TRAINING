package com.rcoem.redbus.controller;

import com.rcoem.redbus.dto.BookingDTO;
import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.service.implementation.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController{

    @Autowired
    BookingServiceImpl bookingService;

    @PostMapping("/")
    public Booking createBooking(@RequestBody BookingDTO booking, @AuthenticationPrincipal UserDetails user){
        String username = user.getUsername();
        return bookingService.createBooking(booking,username);
    }

    @GetMapping("/")
    public List<Booking> getAllBooking() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long booking_id) {
        return bookingService.findById(booking_id);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long booking_id) {
        bookingService.deleteBooking(booking_id);
    }
}
