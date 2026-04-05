package com.rcoem.redbus.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToMany
    private List<Passenger> passengers;
}
