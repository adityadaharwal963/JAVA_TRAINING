package com.rcoem.redbus.service;

import com.rcoem.redbus.dto.BookingDTO;
import com.rcoem.redbus.entities.Booking;

import java.util.List;

public interface BookingService {
    public List<Booking> findAll();
    public Booking findById(Long id);
    public Booking createBooking(BookingDTO booking, String username);
    public void deleteBooking(Long booking_id);
}
