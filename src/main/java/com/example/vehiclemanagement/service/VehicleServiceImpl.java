package com.example.vehiclemanagement.service;

import com.example.vehiclemanagement.entity.Vehicle;
import com.example.vehiclemanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new RuntimeException("Vehicle not found with ID: " + id);
        }
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existingVehicle = getVehicleById(id);


        existingVehicle.setName(updatedVehicle.getName());
        existingVehicle.setFuelType(updatedVehicle.getFuelType());
        existingVehicle.setRegistrationNo(updatedVehicle.getRegistrationNo());
        existingVehicle.setOwnerName(updatedVehicle.getOwnerName());
        existingVehicle.setOwnerAddress(updatedVehicle.getOwnerAddress());
        existingVehicle.setCity(updatedVehicle.getCity());
        existingVehicle.setState(updatedVehicle.getState());

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> searchVehiclesByFuelType(String fuelType) {
        return vehicleRepository.findByFuelType(fuelType);
    }

    @Override
    public List<Vehicle> searchVehiclesByCity(String city) {
        return vehicleRepository.findByCity(city);
    }

    @Override
    public List<Vehicle> searchVehiclesByState(String state) {
        return vehicleRepository.findByState(state);
    }
}
