# 🧳 Smart Tourism and Tour Booking System
A simple **Java-based console application** for booking travel packages, hotels, and guided tours. This system allows both **users** and **admins** to interact with the platform in different roles.

---

## ✨ Features

### 👤 User Panel
- View all available tour packages (destination, price, attractions)
- Choose a tour package and enter:
  - Travel date
  - Duration
- View main tourist attractions in the selected location
- Optionally view hotels in the area and book rooms
  - Choose room type: Single, Double, Twin, Deluxe, Suite
  - Enter number of rooms
  - Provide check-in and check-out dates

### 🔐 Admin Panel
- Add new tour packages with:
  - Destination
  - Price
  - List of attractions
- View all user bookings (package, travel info, and hotel booking details)

---

## 🛠️ Technologies Used
- **Language**: Java
- **Concepts Applied**:
  - Object-Oriented Programming (OOP): Inheritance, Encapsulation, Polymorphism
  - Classes, Objects, Constructors
  - Control Statements and Functions
  - Interfaces and Packages (in further versions)

---

## 🗂️ File Structure

- Main.java: Main driver file (Booking System)
- User.java (User class): booking and viewing packages
- Admin.java (Admin class): adding/viewing packages and bookings
- TourPackage.java: Data structure for tour packages
- Hotel.java: Hotel options and room types
- Booking.java: User booking details (including hotel info)

---

## 🚀 Getting Started

- Login as admin by entering: admin
Add new packages and view all bookings

- Login as user by entering any other name 
View and book packages and hotel rooms interactively

## 📌 Future Improvements
Data persistence using files or database

Real-time hotel availability check

User authentication and session handling

Search and filter packages by destination or price

## 📚 Credits
Developed as part of an OOP course project to demonstrate practical use of Java programming fundamentals.

## 📄 License
This project is open-source and free to use for educational purposes.
