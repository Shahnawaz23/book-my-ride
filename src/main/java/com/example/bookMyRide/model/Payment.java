package com.example.bookMyRide.model;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    Ride ride;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
