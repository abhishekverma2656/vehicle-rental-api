package com.Sprinboot.VehicleRental.controller;

import com.Sprinboot.VehicleRental.entity.Booking;
import com.Sprinboot.VehicleRental.entity.Vehicle;
import com.Sprinboot.VehicleRental.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
       return ResponseEntity.status(HttpStatus.CREATED).body( bookingService.createBookings(booking));
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<Booking> getBookingsById(@PathVariable Long id){
       return ResponseEntity.ok(bookingService.getBookingById(id)) ;
    }

    @GetMapping
    public ResponseEntity <List<Booking>> getAllBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings()) ;
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<List<Booking>> getCustomerBookingById(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getCustomerBookingsById(id)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(Long id){
        bookingService.cancelBooking(id);
        return ResponseEntity.noContent().build();

    }


}
