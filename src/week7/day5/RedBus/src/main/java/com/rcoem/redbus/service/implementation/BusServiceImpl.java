package com.rcoem.redbus.service.implementation;

import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Bus;
import com.rcoem.redbus.repositories.BusRepository;
import com.rcoem.redbus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus create(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Override
    public Bus findById(Long id) {
        return busRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Booking> findAllBookings(Long bus_id) {
        return busRepository.findById(bus_id).orElseThrow().getBookings();
    }

    @Override
    @Transactional
    public Bus update(Bus bus) {
        Bus bus1 = busRepository.findById(bus.getId()).orElseThrow();
        if (bus.getName()!= null) bus1.setName(bus.getName());
        if (bus.getCompany()!= null) bus1.setCompany(bus.getCompany());
        if (bus.getSource()!= null) bus1.setSource(bus.getSource());
        if (bus.getDestination()!= null) bus1.setDestination(bus.getDestination());
        return busRepository.save(bus1);
    }


}
