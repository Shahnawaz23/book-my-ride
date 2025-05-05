package com.example.bookMyRide.dto.request;

import com.example.bookMyRide.model.Enum.CabStatus;

public class CabRequest {

    String cabName;
    String cabNo;
    CabStatus cabStatus;
    int driverId;

    public CabRequest() {
    }

    public CabRequest(String cabName, String cabNo, CabStatus cabStatus, int driverId) {
        this.cabName = cabName;
        this.cabNo = cabNo;
        this.cabStatus = cabStatus;
        this.driverId = driverId;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    //Builder class
    public static class CabRequestBuilder {
        private String cabName;
        private String cabNo;
        private CabStatus cabStatus;
        private int driverId;

        // Builder Setter Methods
        public CabRequestBuilder cabName(String cabName) {
            this.cabName = cabName;
            return this;
        }

        public CabRequestBuilder cabNo(String cabNo) {
            this.cabNo = cabNo;
            return this;
        }

        public CabRequestBuilder cabStatus(CabStatus cabStatus) {
            this.cabStatus = cabStatus;
            return this;
        }

        public CabRequestBuilder driverId(int driverId) {
            this.driverId = driverId;
            return this;
        }

        // Build Method
        public CabRequest build() {
            return new CabRequest(cabName, cabNo, cabStatus, driverId);
        }
    }
}
