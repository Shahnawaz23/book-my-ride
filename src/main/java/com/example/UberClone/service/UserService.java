package com.example.UberClone.service;

import com.example.UberClone.dto.request.UserRequest;
import com.example.UberClone.dto.response.UserResponse;
import com.example.UberClone.model.User;
import com.example.UberClone.repository.UserRepository;
import com.example.UberClone.trnasformer.UserTransformer;
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
