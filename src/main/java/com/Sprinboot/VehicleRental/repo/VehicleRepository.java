package com.Sprinboot.VehicleRental.repo;

import com.Sprinboot.VehicleRental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
