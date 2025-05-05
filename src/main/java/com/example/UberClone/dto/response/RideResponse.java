package com.example.UberClone.dto.response;

public class RideResponse {

    double fare;
    int driverId;

    //no args constructor
    public RideResponse() {
    }

    // All-argument constructor
    public RideResponse(double fare, int driverId) {
        this.fare = fare;
        this.driverId = driverId;
    }

    // Getters
    public double getFare() {
        return fare;
    }

    public int getDriverId() {
        return driverId;
    }

    // Setters
    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    // Builder class
    public static class Builder {
        private double fare;
        private int driverId;

        public Builder fare(double fare) {
            this.fare = fare;
            return this;
        }

        public Builder driverId(int driverId) {
            this.driverId = driverId;
            return this;
        }

        public RideResponse build() {
            return new RideResponse(fare, driverId);
        }
    }
}
