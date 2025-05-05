package com.example.UberClone.controller;


import com.example.UberClone.dto.request.DriverRequest;
import com.example.UberClone.dto.response.DriverResponse;
import com.example.UberClone.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest) {

        DriverResponse driverResponse = driverService.addDriver(driverRequest);

        return new ResponseEntity<>(driverResponse, HttpStatus.CREATED);
    }
}
