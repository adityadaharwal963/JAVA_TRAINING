package com.rcoem.zomato_demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;

    @OneToMany // To be updated with Many to Many
    private List<MenuItem> menuItems;
    private double amount;

    private String status;
}
