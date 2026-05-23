# IRCTC-backend-project

A console-based railway ticket booking backend system inspired by IRCTC, built using Core Java.
The project focuses on backend logic, object-oriented design, file handling, and service-based architecture without using frameworks.

---

## Features

* User Registration & Login
* Train Search
* Seat Availability Check
* Ticket Booking
* Ticket Cancellation
* JSON/File-Based Data Storage
* Modular Service Architecture

---

## Tech Stack

* Core Java
* OOP Concepts
* Java Collections Framework
* File Handling
* Jackson Databind
* IntelliJ IDEA

---

## Project Structure

```plaintext
src/
│
├── entities/
│   ├── User.java
│   ├── Train.java
│   └── Ticket.java
│
├── services/
│   ├── UserService.java
│   ├── TrainService.java
│   └── UserBookingService.java
│
├── util/
│   └── UserServiceUtil.java
│
└── App.java
```

---

## Concepts Used

* Object-Oriented Programming
* Encapsulation
* Abstraction
* Collections
* Exception Handling
* File Handling
* JSON Serialization & Deserialization
* Date & Time API

---

## Functional Flow

### User Flow

1. Register/Login
2. Search trains
3. Check seat availability
4. Book ticket
5. Cancel ticket

### Booking Logic

* Validate seats
* Allocate seats
* Generate ticket
* Update train data

---

## How to Run

### Clone Repository

```bash
git clone <repository-link>
```

### Run Project

1. Open project in IntelliJ IDEA
2. Configure JDK
3. Run `App.java`

---

## Future Improvements

* Database Integration
* Spring Boot REST APIs
* JWT Authentication
* Waiting List System
* Payment Integration
* Admin Panel
* Concurrency Handling

---

## Author

Pratyushk1703-prog
