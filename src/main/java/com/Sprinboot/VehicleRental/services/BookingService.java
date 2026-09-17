package com.Sprinboot.VehicleRental.services;

import com.Sprinboot.VehicleRental.entity.Booking;
import com.Sprinboot.VehicleRental.entity.Customer;
import com.Sprinboot.VehicleRental.entity.Vehicle;
import com.Sprinboot.VehicleRental.repo.BookingRepository;
import com.Sprinboot.VehicleRental.repo.CustomerRepository;
import com.Sprinboot.VehicleRental.repo.VehicleRepository;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;


    public BookingService(BookingRepository bookingRepository, CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Booking createBookings(Booking booking){
       Customer existCustomer= customerRepository.findById(booking.getCustomer().getId())
                .orElseThrow(()-> new RuntimeException("Invalid Customer id"));
       booking.setCustomer(existCustomer);

       Vehicle existVehicle=vehicleRepository.findById(booking.getVehicle().getId())
               .orElseThrow(()-> new RuntimeException("Invalid Vehicle Id"));
       booking.setVehicle(existVehicle);

       if(!booking.getStartDate().isBefore(booking.getEndDate())){
           throw new RuntimeException("Dates are not Valid");
       }
       Long days= ChronoUnit.DAYS.between(booking.getStartDate(),booking.getEndDate());
       Double totalPrice=days*existVehicle.getPricePerDay();
       booking.setTotalPrice(totalPrice);

      return bookingRepository.save(booking);


    }

    public Booking getBookingById(Long id){
        return bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id doesn't Exists"));

    }
     public List<Booking> getAllBookings(){
       return bookingRepository.findAll();
     }

     public List<Booking> getCustomerBookingsById(Long id){
        customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id doesn't found "));
         return bookingRepository.findByCustomerId(id);

     }
     public void cancelBooking(Long id){
        if(!bookingRepository.existsById(id)){
            throw new RuntimeException("Booking Id not Found");
        }
        bookingRepository.deleteById(id);
     }




}
