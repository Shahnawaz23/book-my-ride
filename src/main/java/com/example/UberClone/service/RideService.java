package com.example.UberClone.service;

import com.example.UberClone.dto.request.RideRequest;
import com.example.UberClone.dto.response.RideResponse;
import com.example.UberClone.exceptions.DriverNotFound;
import com.example.UberClone.exceptions.NoCabFound;
import com.example.UberClone.exceptions.UserNotFound;
import com.example.UberClone.model.Cab;
import com.example.UberClone.model.Driver;
import com.example.UberClone.model.Enum.CabStatus;
import com.example.UberClone.model.Ride;
import com.example.UberClone.model.User;
import com.example.UberClone.repository.CabRepository;
import com.example.UberClone.repository.DriverRepository;
import com.example.UberClone.repository.RideRepository;
import com.example.UberClone.repository.UserRepository;
import com.example.UberClone.trnasformer.RideTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RideService {

    @Autowired
    RideRepository rideRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    UserRepository userRepository;

    public RideResponse bookRide(RideRequest rideRequest) {

        List<Cab> cabList = cabRepository.findAll();
        Optional<Driver> driverOptional = driverRepository.findById(rideRequest.getDriverId());
        Optional<User> userOptional = userRepository.findById(rideRequest.getUserId());
        double distance = rideRequest.getDistance();


        Ride savedRide = null;

        for(Cab cab : cabList) {
            if(cab.getCabStatus().equals(CabStatus.AVAILABLE)) {
                if(driverOptional.isEmpty()) {
                    throw new DriverNotFound("Driver is unavailable");
                }

                if (userOptional.isEmpty()) {
                    throw new UserNotFound("User is not registered");
                }

                    Driver driver = driverOptional.get();
                    User user = userOptional.get();
                    double fare = distance * 20;
                    Ride ride = RideTransformer.rideRequestToRide(rideRequest);
                    ride.setDriver(driver);
                    ride.setUser(user);
                    ride.setFare(fare);

                    savedRide = rideRepository.save(ride);
                    break;

            } else {
                throw new NoCabFound("No cab is Available");
            }
        }
        return RideTransformer.rideToRideResponse(savedRide);
    }
}
