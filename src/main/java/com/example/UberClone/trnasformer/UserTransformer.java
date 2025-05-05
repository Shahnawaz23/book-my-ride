package com.example.UberClone.trnasformer;

import com.example.UberClone.dto.request.UserRequest;
import com.example.UberClone.dto.response.UserResponse;
import com.example.UberClone.model.User;

public class UserTransformer {

    public static User userRequestToUser(UserRequest userRequest) {

        return new User.Builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phoneNo(userRequest.getPhoneNo())
                .gender(userRequest.getGender())
                .age(userRequest.getAge())
                .build();
    }

    public static UserResponse userToUserResponse(User user) {
        return new UserResponse.UserResponseBuilder()
                .name(user.getName())
                .phoneNo(user.getPhoneNo())
                .gender(user.getGender())
                .age(user.getAge())
                .build();
    }
}
