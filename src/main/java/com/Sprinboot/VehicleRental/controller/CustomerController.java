package com.Sprinboot.VehicleRental.controller;

import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    public ResponseEntity<Customer>(@RequestBody Customer customer){
//        Customer saveCustomer=customerService
//
//    }
}
