package com.example.UberClone.service;

import com.example.UberClone.exceptions.DriverNotFound;
import com.example.UberClone.dto.request.CabRequest;
import com.example.UberClone.dto.response.CabResponse;
import com.example.UberClone.model.Cab;
import com.example.UberClone.model.Driver;
import com.example.UberClone.repository.CabRepository;
import com.example.UberClone.repository.DriverRepository;
import com.example.UberClone.trnasformer.CabTransformer;
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
