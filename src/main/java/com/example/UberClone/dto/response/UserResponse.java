package com.example.UberClone.dto.response;

import com.example.UberClone.model.Enum.Gender;

public class UserResponse {

    String name;

    String phoneNo;

    Gender gender;

    int age;

    public UserResponse(String name, String phoneNo, Gender gender, int age) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
    }

    private UserResponse(UserResponseBuilder builder) {
        this.name = builder.name;
        this.phoneNo = builder.phoneNo;
        this.gender = builder.gender;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class UserResponseBuilder {
        private String name;
        private String phoneNo;
        private Gender gender;
        private int age;

        // Setter methods that return the builder instance
        public UserResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserResponseBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public UserResponseBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public UserResponseBuilder age(int age) {
            this.age = age;
            return this;
        }

        // Build method to create an instance of UserResponse
        public UserResponse build() {
            return new UserResponse(this);
        }
    }
}

