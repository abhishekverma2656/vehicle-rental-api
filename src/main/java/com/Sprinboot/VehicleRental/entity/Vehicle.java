package com.Sprinboot.VehicleRental.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String vehicleType;

    private String numberPlate;

    private Double vehiclePrice;

    private Double pricePerDay;

    @OneToMany(mappedBy = "vehicle")
    List<Booking> bookings;


    public Vehicle() {
    }

    public Vehicle(String model, String vehicleType, String numberPlate, Double vehiclePrice, Double pricePerDay) {
        this.model = model;
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.vehiclePrice = vehiclePrice;
        this.pricePerDay = pricePerDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
