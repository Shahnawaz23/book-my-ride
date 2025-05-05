package com.example.bookMyRide.controller;

import com.example.bookMyRide.dto.request.UserRequest;
import com.example.bookMyRide.dto.response.UserResponse;
import com.example.bookMyRide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

}
