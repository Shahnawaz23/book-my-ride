package com.example.bookMyRide.trnasformer;

import com.example.bookMyRide.dto.request.UserRequest;
import com.example.bookMyRide.dto.response.UserResponse;
import com.example.bookMyRide.model.User;

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
