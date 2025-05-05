package com.example.bookMyRide.repository;

import com.example.bookMyRide.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Integer> {
}
