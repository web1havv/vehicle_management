package com.example.vehiclemanagement.service;

import com.example.vehiclemanagement.entity.Vehicle;

import java.util.List;

public interface VehicleService {


    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);


    List<Vehicle> searchVehiclesByFuelType(String fuelType);
    List<Vehicle> searchVehiclesByCity(String city);
    List<Vehicle> searchVehiclesByState(String state);
}
