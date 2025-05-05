package com.example.UberClone.trnasformer;

import com.example.UberClone.dto.request.RideRequest;
import com.example.UberClone.dto.response.RideResponse;
import com.example.UberClone.model.Ride;

public class RideTransformer {

    public static Ride rideRequestToRide(RideRequest rideRequest) {
        return new Ride.Builder()
                .startLocation(rideRequest.getStartLocation())
                .endLocation(rideRequest.getEndLocation())
                .distance(rideRequest.getDistance())
                .build();
    }

    public static RideResponse rideToRideResponse(Ride ride) {
        return new RideResponse.Builder()
                .fare(ride.getFare())
                .driverId(ride.getDriver().getId())
                .build();
    }
}
