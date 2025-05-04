public class Admin {
    String username;

    public Admin(String username) {
        this.username = username;
    }

    public void addPackage(TourPackage[] packages, int count, String destination, double price, String[] attractions) {
        packages[count] = new TourPackage(destination, price, attractions);
        System.out.println("✅ Package added successfully.");
    }

    public void viewBookings(Booking[] bookings, int bookingCount) {
        System.out.println("\n--- All Bookings ---");
        for (int i = 0; i < bookingCount; i++) {
            bookings[i].display();
        }
        if (bookingCount == 0) {
            System.out.println("No bookings yet.");
        }
    }
}
