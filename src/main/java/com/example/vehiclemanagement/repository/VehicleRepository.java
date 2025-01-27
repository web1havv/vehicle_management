package com.example.vehiclemanagement.repository;

import com.example.vehiclemanagement.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    List<Vehicle> findByFuelType(String fuelType);
    List<Vehicle> findByCity(String city);
    List<Vehicle> findByState(String state);
}
