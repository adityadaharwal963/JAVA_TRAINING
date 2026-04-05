package com.rcoem.redbus.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String company;
    private Integer booked_seat;
    private Integer total_seat;
    private String source;
    private String destination;
    private Float fare;

    @OneToMany
    private List<Booking> bookings;
}
