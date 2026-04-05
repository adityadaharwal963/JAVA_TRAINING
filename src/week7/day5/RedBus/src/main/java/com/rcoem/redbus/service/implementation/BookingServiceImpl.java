package com.rcoem.redbus.service.implementation;

import com.rcoem.redbus.dto.BookingDTO;
import com.rcoem.redbus.entities.Booking;
import com.rcoem.redbus.entities.Bus;
import com.rcoem.redbus.entities.Passenger;
import com.rcoem.redbus.entities.UserInfo;
import com.rcoem.redbus.exception.ResourceNotFoundException;
import com.rcoem.redbus.repositories.BookingRepository;
import com.rcoem.redbus.repositories.BusRepository;
import com.rcoem.redbus.repositories.PassengerRepository;
import com.rcoem.redbus.repositories.UserInfoRepository;
import com.rcoem.redbus.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    BusRepository busRepository;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    @Override
    public Booking createBooking(BookingDTO booking, String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username); // used for checking passenger entity is owned by User
        Bus bus = busRepository.findById(booking.getBus_id()).orElseThrow();
        Booking bookingEntity = new Booking();

        if (userInfo == null) {
            throw new ResourceNotFoundException("User not found, Pls Logout");
        }

        if(bus.getTotal_seat()< booking.getSeats()+bus.getBooked_seat()){
            throw new RuntimeException("Not enough seat");
        }

        List<Passenger> passengers = new ArrayList<>();
        for (Long passenger_id : booking.getPassengerIds()) {
            Passenger passenger = passengerRepository.findById(passenger_id).orElseThrow();
            passengers.add(passenger);
        }
        bookingEntity.setDate(booking.getDate());
        bookingEntity.setBus(bus);
        bookingEntity.setPassengers(passengers);
        return bookingRepository.save(bookingEntity);
    }



    @Override
    public void deleteBooking(Long booking_id) {
        Booking booking = bookingRepository.findById(booking_id).orElseThrow();
        Bus bus = booking.getBus();
        bus.setBooked_seat(bus.getBooked_seat()-booking.getSeats());
        busRepository.save(bus);
        bookingRepository.delete(booking);
    }

}
