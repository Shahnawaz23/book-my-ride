package com.example.UberClone.trnasformer;

import com.example.UberClone.dto.request.DriverRequest;
import com.example.UberClone.dto.response.DriverResponse;
import com.example.UberClone.model.Driver;

public class DriverTransformer {
    public static Driver driverRequestToDriver(DriverRequest driverRequest) {

        return new Driver.DriverBuilder()
                .name(driverRequest.getName())
                .email(driverRequest.getEmail())
                .phoneNo(driverRequest.getPhoneNo())
                .driverStatus(driverRequest.getDriverStatus())
                .licenseNo(driverRequest.getLicenseNo())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver) {

        return new DriverResponse.DriverResponseBuilder()
                .name(driver.getName())
                .phoneNo(driver.getPhoneNo())
                .driverStatus(driver.getDriverStatus())
                .build();
    }
}
