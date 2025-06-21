# 🌍 Smart Tourism Booking System

A basic Java + PostgreSQL console-based project that allows users to browse and book tour packages, with optional hotel booking. Admins can manage packages and view bookings.

---

## 🧾 Features

### 👤 User Panel
- View all available tour packages
- Book a package (with travel date and duration)
- Optionally add hotel booking (room type, count, check-in/out dates)

### 🔐 Admin Panel
- Admin login (`username: admin`, `password: admin123`)
- Add new tour packages (with multiple attractions)
- View all user bookings (includes hotel booking status)
- View all hotel booking details separately

---

## 🗂️ Java Files

| File Name          | Purpose                                                                 |
|--------------------|-------------------------------------------------------------------------|
| `Main.java`        | Entry point of the system, handles user and admin menus                |
| `Admin.java`       | Admin actions: add package, view bookings, view hotel bookings         |
| `Booking.java`     | Booking class: stores and fetches user bookings                        |
| `Hotel.java`       | Hotel class: displays room options and handles hotel booking logic     |
| `TourPackage.java` | Defines and stores tour package and its attractions                    |
| `DatabaseCon.java` | Connects Java app to PostgreSQL using JDBC                             |
| `HotelBooking.java`| (optional) Used to display hotel booking details cleanly               |

---

## 🧱 PostgreSQL Tables

### 1. `tour_packages`
```sql
CREATE TABLE tour_packages (
  id SERIAL PRIMARY KEY,
  destination TEXT,
  price NUMERIC
);
```

### 2. `attractions`
```sql
CREATE TABLE attractions (
  id SERIAL PRIMARY KEY,
  package_id INTEGER REFERENCES tour_packages(id),
  attraction TEXT
);
```

### 3. `bookings`
```sql
CREATE TABLE bookings (
  id SERIAL PRIMARY KEY,
  username TEXT,
  package_id INTEGER REFERENCES tour_packages(id),
  travel_date DATE,
  duration TEXT
);
```

### 4. `hotel_bookings`
```sql
CREATE TABLE hotel_bookings (
  id SERIAL PRIMARY KEY,
  booking_id INTEGER REFERENCES bookings(id),
  room_type TEXT,
  room_count INTEGER,
  check_in DATE,
  check_out DATE
);
```

---

## ⚙️ How to Run

1. Ensure PostgreSQL is running and your `Tourism` database is created.
2. Update credentials in `DatabaseCon.java`:
```java
"jdbc:postgresql://localhost:5432/Tourism", "your_username", "your_password"
```
3. Compile and run:
```bash
javac *.java
java Main
```

---

## 📌 Notes
- Booking IDs are auto-generated.
- Hotel booking is optional — stored only when selected.
- Admin has exclusive access to add/view bookings.
