package com.example.bookMyRide.repository;

import com.example.bookMyRide.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findById(int id);
}
