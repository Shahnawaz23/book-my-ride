package com.example.bookMyRide.service;

import com.example.bookMyRide.exceptions.DriverNotFound;
import com.example.bookMyRide.dto.request.CabRequest;
import com.example.bookMyRide.dto.response.CabResponse;
import com.example.bookMyRide.model.Cab;
import com.example.bookMyRide.model.Driver;
import com.example.bookMyRide.repository.CabRepository;
import com.example.bookMyRide.repository.DriverRepository;
import com.example.bookMyRide.trnasformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRepository cabRepository;


    public CabResponse addCab(CabRequest cabRequest) {

        Optional<Driver> driverOptional = driverRepository.findById(cabRequest.getDriverId());

        if(driverOptional.isEmpty()) {
            throw new DriverNotFound("First register as Driver");
        }

        Driver driver1 = driverOptional.get();

        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        cab.setDriver(driver1);

        Cab savedCab = cabRepository.save(cab);

        return CabTransformer.cabToCabResponse(savedCab);
    }
}
