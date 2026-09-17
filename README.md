# Vehicle Rental API

A backend REST API for managing customers, vehicles, and vehicle bookings.

Built using **Java, Spring Boot, Spring Data JPA and MySQL**.

## 🚀 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* REST API
* Postman

## 📌 Features

### Customer Management

* Create customer
* Get customer by ID
* Update customer
* Delete customer
* Prevent duplicate email

### Vehicle Management

* Add vehicle
* Get vehicle by ID
* Get all vehicles
* Update vehicle rental price
* Delete vehicle
* Prevent duplicate vehicle number plate

### Booking Management

* Create booking
* Get booking by ID
* Get all bookings
* Get bookings of a customer
* Cancel booking
* Automatically calculate total rental price

## 🏗️ Project Structure

```text
src/main/java/com/Sprinboot/VehicleRental/

├── entity/
│   ├── Customer.java
│   ├── Vehicle.java
│   └── Booking.java
│
├── repo/
│   ├── CustomerRepository.java
│   ├── VehicleRepository.java
│   └── BookingRepository.java
│
├── services/
│   ├── CustomerService.java
│   ├── VehicleService.java
│   └── BookingService.java
│
└── controller/
    ├── CustomerController.java
    ├── VehicleController.java
    └── BookingController.java
```

## 🔗 Entity Relationships

```text
Customer 1 ─────< Booking >───── 1 Vehicle
```

A customer can have multiple bookings.

A vehicle can also have multiple bookings over time.

The `Booking` entity contains the foreign keys:

```text
booking
-------------------------------
id | customer_id | vehicle_id
-------------------------------
```

## 🌐 API Endpoints

### Customer

| Method | Endpoint         | Description     |
| ------ | ---------------- | --------------- |
| POST   | `/customer`      | Create customer |
| GET    | `/customer/{id}` | Get customer    |
| PUT    | `/customer/{id}` | Update customer |
| DELETE | `/customer/{id}` | Delete customer |

### Vehicle

| Method | Endpoint        | Description         |
| ------ | --------------- | ------------------- |
| POST   | `/vehicle`      | Add vehicle         |
| GET    | `/vehicle/{id}` | Get vehicle         |
| GET    | `/vehicle`      | Get all vehicles    |
| PATCH  | `/vehicle/{id}` | Update rental price |
| DELETE | `/vehicle/{id}` | Delete vehicle      |

### Booking

| Method | Endpoint                 | Description             |
| ------ | ------------------------ | ----------------------- |
| POST   | `/booking`               | Create booking          |
| GET    | `/booking/{id}`          | Get booking             |
| GET    | `/booking`               | Get all bookings        |
| GET    | `/booking/customer/{id}` | Get customer's bookings |
| DELETE | `/booking/{id}`          | Cancel booking          |

## 🧮 Booking Price Calculation

When a booking is created:

```text
Number of Days
      ×
Vehicle Price Per Day
      =
Total Price
```

For example:

```text
Start Date : 20 Sep
End Date   : 23 Sep

3 days × ₹1000/day
= ₹3000
```

## 🔄 Application Flow

```text
Client / Postman
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
Spring Data JPA
       ↓
Hibernate
       ↓
MySQL
```

## 🎯 Purpose

This project is built as a practical Spring Boot backend project to understand:

* REST API development
* Layered architecture
* JPA/Hibernate
* Entity relationships
* Repository pattern
* Service-layer business logic
* Database relationships
* CRUD operations
* API testing with Postman

##
