package com.rcoem.redbus.service;

import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Passenger;

import java.util.List;

public interface PassengerService{
    public Passenger createPassenger(Passenger passenger,String username);
    public Passenger updatePassenger(Passenger passenger);
    public Passenger findPassengerById(Long id);
    public List<Passenger> findAll();
    public List<Booking> findAllBookingsByPassenger(Long passenger_id);
}
