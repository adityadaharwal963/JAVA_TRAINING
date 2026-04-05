package com.rcoem.redbus.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    @Size(min= 10 , max= 10)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "passenger_booking" ,  joinColumns = @JoinColumn(name = "passenger_id"),inverseJoinColumns = @JoinColumn(name = "booking_id"))
    private List<Booking> bookings;
}
