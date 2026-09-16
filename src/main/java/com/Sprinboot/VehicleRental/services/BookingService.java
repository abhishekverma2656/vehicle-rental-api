package com.Sprinboot.VehicleRental.services;

import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.repo.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


}
