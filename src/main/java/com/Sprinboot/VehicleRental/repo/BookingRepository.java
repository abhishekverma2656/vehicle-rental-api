package com.Sprinboot.VehicleRental.repo;

import com.Sprinboot.VehicleRental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
