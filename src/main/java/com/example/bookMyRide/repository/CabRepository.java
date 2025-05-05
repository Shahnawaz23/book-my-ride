package com.example.bookMyRide.repository;

import com.example.bookMyRide.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab,Integer> {
}
