package com.example.bookMyRide.service;

import com.example.bookMyRide.dto.request.RideRequest;
import com.example.bookMyRide.dto.response.RideResponse;
import com.example.bookMyRide.exceptions.DriverNotFound;
import com.example.bookMyRide.exceptions.NoCabFound;
import com.example.bookMyRide.exceptions.UserNotFound;
import com.example.bookMyRide.model.Cab;
import com.example.bookMyRide.model.Driver;
import com.example.bookMyRide.model.Enum.CabStatus;
import com.example.bookMyRide.model.Ride;
import com.example.bookMyRide.model.User;
import com.example.bookMyRide.repository.CabRepository;
import com.example.bookMyRide.repository.DriverRepository;
import com.example.bookMyRide.repository.RideRepository;
import com.example.bookMyRide.repository.UserRepository;
import com.example.bookMyRide.trnasformer.RideTransformer;
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
