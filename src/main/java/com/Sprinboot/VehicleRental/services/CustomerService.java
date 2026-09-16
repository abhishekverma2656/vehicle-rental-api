package com.Sprinboot.VehicleRental.services;

import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.repo.CustomerRepository;
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
    public Customer updateCustomer(Long id,Customer customer){
        Customer existingCustomer=customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer id not found"));
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomerById(Long id) {

        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }

        customerRepository.deleteById(id);
    }
}









