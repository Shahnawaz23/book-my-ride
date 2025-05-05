package com.example.bookMyRide.service;

import com.example.bookMyRide.dto.request.UserRequest;
import com.example.bookMyRide.dto.response.UserResponse;
import com.example.bookMyRide.model.User;
import com.example.bookMyRide.repository.UserRepository;
import com.example.bookMyRide.trnasformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {

        User user = UserTransformer.userRequestToUser(userRequest);

        User saveUser = userRepository.save(user);

        return UserTransformer.userToUserResponse(saveUser);
    }
}
