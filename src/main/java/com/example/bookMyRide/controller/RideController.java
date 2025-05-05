package com.example.bookMyRide.controller;

import com.example.bookMyRide.dto.request.RideRequest;
import com.example.bookMyRide.dto.response.RideResponse;
import com.example.bookMyRide.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/ride")
public class RideController {

    @Autowired
    RideService rideService;

    @PostMapping
    public ResponseEntity bookRide(@RequestBody RideRequest rideRequest) {

        RideResponse rideResponse = rideService.bookRide(rideRequest);

        return new ResponseEntity<>(rideResponse, HttpStatus.CREATED);
    }
}
