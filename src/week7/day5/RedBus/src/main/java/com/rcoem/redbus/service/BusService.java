package com.rcoem.redbus.service;

import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Bus;

import java.util.List;

public interface BusService {
    public Bus create(Bus bus);
    public List<Bus> findAll();
    public Bus findById(Long id);
    public List<Booking>  findAllBookings(Long bus_id);
    public Bus update(Bus bus);
}
