package com.Sprinboot.VehicleRental.controller;

import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer savedCustomer=customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        Customer updatedCustomer=customerService.updateCustomer(id,customer);
        return  ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
         return ResponseEntity.noContent().build();
    }




    }



