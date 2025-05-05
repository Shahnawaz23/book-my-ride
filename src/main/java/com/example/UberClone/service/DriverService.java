package com.example.UberClone.service;

import com.example.UberClone.dto.request.DriverRequest;
import com.example.UberClone.dto.response.DriverResponse;
import com.example.UberClone.model.Driver;
import com.example.UberClone.repository.DriverRepository;
import com.example.UberClone.trnasformer.DriverTransformer;
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
