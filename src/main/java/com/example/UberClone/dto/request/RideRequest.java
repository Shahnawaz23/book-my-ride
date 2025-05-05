package com.example.UberClone.dto.request;

public class RideRequest {

    String startLocation;
    String endLocation;
    double distance;
    int userId;
    int driverId;

    public RideRequest() {
    }

    // All-argument constructor
    public RideRequest(String startLocation, String endLocation, double distance, int userId, int driverId) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.userId = userId;
        this.driverId = driverId;
    }

    // Getters
    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public int getUserId() {
        return userId;
    }

    public int getDriverId() {
        return driverId;
    }

    // Setters
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    // Builder class
    public static class Builder {
        private String startLocation;
        private String endLocation;
        private double distance;
        private int userId;
        private int driverId;

        public Builder setStartLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public Builder setEndLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public Builder setDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder setDriverId(int driverId) {
            this.driverId = driverId;
            return this;
        }

        public RideRequest build() {
            return new RideRequest(startLocation, endLocation, distance, userId, driverId);
        }
    }
}


