package com.example.bookMyRide.service;

import com.example.bookMyRide.dto.request.DriverRequest;
import com.example.bookMyRide.dto.response.DriverResponse;
import com.example.bookMyRide.model.Driver;
import com.example.bookMyRide.repository.DriverRepository;
import com.example.bookMyRide.trnasformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {

        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);

        Driver saveDriver = driverRepository.save(driver);

        return DriverTransformer.driverToDriverResponse(saveDriver);
    }
}
