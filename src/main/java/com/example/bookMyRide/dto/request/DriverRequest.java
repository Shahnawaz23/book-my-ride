package com.example.bookMyRide.dto.request;

import com.example.bookMyRide.model.Enum.DriverStatus;

public class DriverRequest {

    String name;
    String email;
    String phoneNo;
    String licenseNo;
    DriverStatus driverStatus;

    public DriverRequest(String name, String email, String phoneNo, String licenseNo, DriverStatus driverStatus) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.licenseNo = licenseNo;
        this.driverStatus = driverStatus;
    }

    public DriverRequest() {

    }

    // Private constructor for Builder
    private DriverRequest(DriverRequestBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNo = builder.phoneNo;
        this.licenseNo = builder.licenseNo;
        this.driverStatus = builder.driverStatus;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    // Builder class
    public static class DriverRequestBuilder {
        private String name;
        private String email;
        private String phoneNo;
        private String licenseNo;
        private DriverStatus driverStatus;

        // Builder setter methods
        public DriverRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DriverRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DriverRequestBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public DriverRequestBuilder licenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
            return this;
        }

        public DriverRequestBuilder driverStatus(DriverStatus driverStatus) {
            this.driverStatus = driverStatus;
            return this;
        }

        // Build method
        public DriverRequest build() {
            return new DriverRequest(this);
        }
    }
}
