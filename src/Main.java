import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseCon db = new DatabaseCon();

        System.out.println("=== Welcome to Smart Tourism Booking System ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (username.equalsIgnoreCase("admin")) {
            System.out.print("Enter admin password: ");
            String pass = sc.nextLine();

            if (pass.equals("admin123")) {
                Admin admin = new Admin(username);
                while (true) {
                    System.out.println("\n--- Admin Panel ---");
                    System.out.println("1. Add Package\n2. View Bookings\n3. Exit");
                    System.out.print("Enter choice: ");
                    int ch = sc.nextInt(); sc.nextLine();

                    if (ch == 1) admin.addPackage(db, sc);
                    else if (ch == 2) admin.viewBookings(db);
                    else break;
                }
            } else {
                System.out.println("Wrong password.");
            }
        } else {
            System.out.println("\n--- User Panel ---");
            while (true) {
                System.out.println("1. View Packages\n2. Book Package\n3. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt(); sc.nextLine();

                if (ch == 1) {
                    try {
                        TourPackage.fetchAll(db);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (ch == 2) {
                    try {
                        System.out.print("Enter package ID to book: ");
                        int packageId = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter travel date (yyyy-mm-dd): ");
                        String travelDate = sc.nextLine();
                        System.out.print("Enter duration: ");
                        String duration = sc.nextLine();

                        Booking booking = new Booking(username, packageId, travelDate, duration);
                        int bookingId = booking.saveAndReturnId(db);

                        System.out.print("Want to book hotel? (yes/no): ");
                        String ans = sc.nextLine();

                        if (ans.equalsIgnoreCase("yes")) {
                            Hotel hotel = new Hotel();
                            hotel.displayHotelOptions();
                            System.out.print("Enter room type number: ");
                            int rt = sc.nextInt(); sc.nextLine();
                            String roomType = hotel.roomTypes[rt - 1];

                            System.out.print("Number of rooms: ");
                            int roomCount = sc.nextInt(); sc.nextLine();

                            System.out.print("Check-in (yyyy-mm-dd): ");
                            String checkIn = sc.nextLine();
                            System.out.print("Check-out (yyyy-mm-dd): ");
                            String checkOut = sc.nextLine();

                            Hotel hotelBooking = new Hotel(roomType, roomCount, checkIn, checkOut, bookingId);
                            hotelBooking.saveToDB(db);
                        }
                        System.out.println("Booking saved!");

                    } catch (Exception e) {
                        System.out.println("Failed to save booking.");
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

        db.close();
        sc.close();
    }
}
