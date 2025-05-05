package com.example.bookMyRide.model;

import com.example.bookMyRide.model.Enum.CabStatus;
import jakarta.persistence.*;

@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cabName;

    @Column(unique = true, nullable = false)
    String cabNo;

    @Enumerated(EnumType.STRING)
    CabStatus cabStatus;

    String location;

    @OneToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

    public Cab() {
    }

    // Parameterized Constructor
    private Cab(CabBuilder builder) {
        this.id = builder.id;
        this.cabName = builder.cabName;
        this.cabNo = builder.cabNo;
        this.cabStatus = builder.cabStatus;
        this.location = builder.location;
        this.driver = builder.driver;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCabName() {
        return cabName;
    }


    public String getCabNo() {
        return cabNo;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public String getLocation() {
        return location;
    }

    public Driver getDriver() {
        return driver;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }


    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    // Builder Class
    public static class CabBuilder {
        public String cabName;
        private int id;
        private String cabNo;
        private CabStatus cabStatus;
        private String location;
        private Driver driver;

        // Setter methods for Builder
        public CabBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CabBuilder cabName(String cabName) {
            this.cabName = cabName;
            return this;
        }

        public CabBuilder cabNo(String cabNo) {
            this.cabNo = cabNo;
            return this;
        }

        public CabBuilder cabStatus(CabStatus cabStatus) {
            this.cabStatus = cabStatus;
            return this;
        }

        public CabBuilder location(String location) {
            this.location = location;
            return this;
        }

        public CabBuilder driver(Driver driver) {
            this.driver = driver;
            return this;
        }

        // Build method
        public Cab build() {
            return new Cab(this);
        }
    }

}
