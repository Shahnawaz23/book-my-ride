package com.example.bookMyRide.controller;


import com.example.bookMyRide.dto.request.CabRequest;
import com.example.bookMyRide.dto.response.CabResponse;
import com.example.bookMyRide.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping
    public ResponseEntity addCab(@RequestBody CabRequest cabRequest) {

        CabResponse cabResponse = cabService.addCab(cabRequest);

        return new ResponseEntity<>(cabRequest, HttpStatus.CREATED);
    }
}
