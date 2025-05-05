package com.example.UberClone.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String startLocation;

    String endLocation;

    double distance;

    double fare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

    @OneToOne
    @JoinColumn(name = "payment_id")
    Payment payment;

    public Ride() {
    }

    // All-argument constructor
    public Ride(int id, String startLocation, String endLocation, double distance, double fare, User user, Driver driver, Payment payment) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.fare = fare;
        this.user = user;
        this.driver = driver;
        this.payment = payment;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return fare;
    }

    public User getUser() {
        return user;
    }

    public Driver getDriver() {
        return driver;
    }

    public Payment getPayment() {
        return payment;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Builder class
    public static class Builder {
        private int id;
        private String startLocation;
        private String endLocation;
        private double distance;
        private double fare;
        private User user;
        private Driver driver;
        private Payment payment;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public Builder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public Builder distance(double distance) {
            this.distance = distance;
            return this;
        }

        public Builder fare(double fare) {
            this.fare = fare;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder friver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Ride build() {
            return new Ride(id, startLocation, endLocation, distance, fare, user, driver, payment);
        }

    }
}
