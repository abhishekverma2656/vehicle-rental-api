package com.Sprinboot.VehicleRental.services;

import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.repo.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){

        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new RuntimeException("Email Already Exists");
        }
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}

public Customer updateCustomer(Long id){
    return CustomerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer id not found"));
}





}
