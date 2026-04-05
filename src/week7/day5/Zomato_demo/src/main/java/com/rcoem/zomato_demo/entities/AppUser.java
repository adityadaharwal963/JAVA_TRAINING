package com.rcoem.zomato_demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max = 50)
    @Column(unique = true,nullable = false)
    private String username;

    @Size(min = 8, max = 16, message = "password must be between 8 and 30 characters")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
