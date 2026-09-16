package com.Sprinboot.VehicleRental.services;
import com.Sprinboot.VehicleRental.entity.Vehicle;
import com.Sprinboot.VehicleRental.repo.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(Vehicle vehicle){
        if(vehicleRepository.existsByNumberPlate(vehicle.getNumberPlate())){
            throw new RuntimeException("Vehicle Number Already Exists");
        }
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Not Found"));
    }

    public Vehicle updateVehiclePrice(Long id,Double pricePerDay){
      Vehicle existingVehicle=  vehicleRepository.findById(id)
              .orElseThrow(()->new RuntimeException("Vehicle id not valid"));

        existingVehicle.setPricePerDay(pricePerDay);

        return vehicleRepository.save(existingVehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicleById(Long id) {

        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("vehicle not found");
        }

        vehicleRepository.deleteById(id);
    }



}
