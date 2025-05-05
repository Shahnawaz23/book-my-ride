package com.example.UberClone.model;

import com.example.UberClone.model.Enum.DriverStatus;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String phoneNo;

    @Column(unique = true, nullable = false)
    String licenseNo;

    @Enumerated(EnumType.STRING)
    DriverStatus driverStatus;


    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Ride> rides = new ArrayList<>();

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    Cab cab;

    public Driver() {

    }

    public Driver(int id, String name, String email, String phoneNo, String licenseNo, DriverStatus driverStatus, User user) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.licenseNo = licenseNo;
        this.driverStatus = driverStatus;
    }

    // Private constructor for builder
    private Driver(DriverBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNo = builder.phoneNo;
        this.licenseNo = builder.licenseNo;
        this.driverStatus = builder.driverStatus;
//        this.user = builder.user;
    }

    // Getters
    public int getId() {
        return id;
    }

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

//    public User getUser() {
//        return user;
//    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

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

//    public void setUser(User user) {
//        this.user = user;
//    }

    // Builder class
    public static class DriverBuilder {
        private int id;
        private String name;
        private String email;
        private String phoneNo;
        private String licenseNo;
        private DriverStatus driverStatus;
//        private User user;

        // Builder setter methods
        public DriverBuilder id(int id) {
            this.id = id;
            return this;
        }

        public DriverBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DriverBuilder email(String email) {
            this.email = email;
            return this;
        }

        public DriverBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public DriverBuilder licenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
            return this;
        }

        public DriverBuilder driverStatus(DriverStatus driverStatus) {
            this.driverStatus = driverStatus;
            return this;
        }

//        public DriverBuilder user(User user) {
//            this.user = user;
//            return this;
//        }

        // Build method
        public Driver build() {
            return new Driver(this);
        }
    }
}
