package com.rcoem.redbus.service.implementation;

import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Passenger;
import com.rcoem.redbus.entities.UserInfo;
import com.rcoem.redbus.repositories.PassengerRepository;
import com.rcoem.redbus.repositories.UserInfoRepository;
import com.rcoem.redbus.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;


    @Override
    public Passenger createPassenger(Passenger passenger,String username) {
        UserInfo user = userInfoRepository.findByUsername(username);
        passenger.setUser(user);
        return passengerRepository.save(passenger);
    }

    @Override
    @Transactional
    public Passenger updatePassenger(Passenger passenger) {
        Passenger passenger1 = passengerRepository.findById(passenger.getId()).orElseThrow();
        if(passenger.getName()!= null) passenger1.setName(passenger.getName());
        if(passenger.getEmail()!= null) passenger1.setEmail(passenger.getEmail());
        if(passenger.getPhone()!= null) passenger1.setPhone(passenger.getPhone());
        passengerRepository.save(passenger1);
        return passenger1;
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return passengerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public List<Booking> findAllBookingsByPassenger(Long passenger_id) {
        return passengerRepository.findById(passenger_id).orElseThrow().getBookings();
    }
}
