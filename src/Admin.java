import java.util.Scanner;

public class Admin {
    String username;

    public Admin(String username) {
        this.username = username;
    }

    public void addPackage(DatabaseCon db, Scanner sc) {
        try {
            System.out.print("Enter destination: ");
            String dest = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Number of attractions: ");
            int n = sc.nextInt();
            sc.nextLine();

            String[] attractions = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Attraction " + (i + 1) + ": ");
                attractions[i] = sc.nextLine();
            }

            TourPackage tp = new TourPackage(dest, price, attractions);
            tp.saveToDB(db);
            System.out.println("✅ Package added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBookings(DatabaseCon db) {
        try {
            for (Booking b : Booking.fetchAllBookings(db)) {
                b.display();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
