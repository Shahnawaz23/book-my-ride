package com.example.UberClone.dto.response;


import com.example.UberClone.model.Enum.CabStatus;

public class CabResponse {

    String cabName;
    String cabNo;
    CabStatus cabStatus;

    public CabResponse() {
    }

    // All-Args Constructor
    public CabResponse(String cabName, String cabNo, CabStatus cabStatus) {
        this.cabName = cabName;
        this.cabNo = cabNo;
        this.cabStatus = cabStatus;
    }

    // Getters
    public String getCabName() {
        return cabName;
    }

    public String getCabNo() {
        return cabNo;
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    // Setters
    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    // Builder Class
    public static class CabResponseBuilder {
        private String cabName;
        private String cabNo;
        private CabStatus cabStatus;

        // Builder setter methods
        public CabResponseBuilder cabName(String cabName) {
            this.cabName = cabName;
            return this;
        }

        public CabResponseBuilder cabNo(String cabNo) {
            this.cabNo = cabNo;
            return this;
        }

        public CabResponseBuilder cabStatus(CabStatus cabStatus) {
            this.cabStatus = cabStatus;
            return this;
        }

        // Build method
        public CabResponse build() {
            return new CabResponse(cabName, cabNo, cabStatus);
        }
    }
}
