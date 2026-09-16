package com.Sprinboot.VehicleRental.repo;

import com.Sprinboot.VehicleRental.entity.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    boolean existsByEmail(String email);
    boolean existsByid(Long id);

}
