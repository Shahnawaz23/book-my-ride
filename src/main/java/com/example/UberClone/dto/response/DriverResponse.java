package com.example.UberClone.dto.response;

import com.example.UberClone.model.Enum.DriverStatus;

public class DriverResponse {

    String name;
    String phoneNo;
    DriverStatus driverStatus;

    public DriverResponse(String name, String phoneNo, DriverStatus driverStatus) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.driverStatus = driverStatus;
    }

    // Private constructor for Builder
    private DriverResponse(DriverResponseBuilder builder) {
        this.name = builder.name;
        this.phoneNo = builder.phoneNo;
        this.driverStatus = builder.driverStatus;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    // Builder class
    public static class DriverResponseBuilder {
        private String name;
        private String phoneNo;
        private DriverStatus driverStatus;

        // Builder setter methods
        public DriverResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DriverResponseBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public DriverResponseBuilder driverStatus(DriverStatus driverStatus) {
            this.driverStatus = driverStatus;
            return this;
        }

        // Build method
        public DriverResponse build() {
            return new DriverResponse(this);
        }
    }
}
