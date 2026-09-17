package com.Sprinboot.VehicleRental.controller;

import com.Sprinboot.VehicleRental.entity.Vehicle;
import com.Sprinboot.VehicleRental.services.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        Vehicle savedVehicle=vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id){
        Vehicle vehicle =vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehiclePrice(@PathVariable Long id,@RequestBody Double pricePerDay){
       Vehicle upDatedVehicle= vehicleService.updateVehiclePrice(id,pricePerDay);
       return ResponseEntity.ok(upDatedVehicle);

    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable Long id){
        vehicleService.deleteVehicleById(id);

        return ResponseEntity.noContent().build();

    }



}
