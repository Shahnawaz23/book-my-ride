package com.example.bookMyRide.model;

import com.example.bookMyRide.model.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Email(message = "Invalid Email Format")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String phoneNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    int age;

    @CreationTimestamp
    Date createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Ride> rides = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Payment> payments = new ArrayList<>();

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    Driver driver;

    public User(int id, String name, String email, String phoneNo, Gender gender, int age, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.age = age;
        this.createdAt = createdAt;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @Email(message = "Invalid Email Format") @NotBlank(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid Email Format") @NotBlank(message = "Email is required") String email) {
        this.email = email;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public static class Builder {
        private int id;
        private String name;
        private String email;
        private String phoneNo;
        private Gender gender;
        private int age;
        private Date createdAt;

        // Setter for id
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        // Setter for name
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        // Setter for email
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        // Setter for phoneNo
        public Builder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        // Setter for gender
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        // Setter for age
        public Builder age(int age) {
            this.age = age;
            return this;
        }

        // Setter for createdAt
        public Builder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        // Build method to create User instance
        public User build() {
            return new User(id, name, email, phoneNo, gender, age, createdAt);
        }
    }
}
