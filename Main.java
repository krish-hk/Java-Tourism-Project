import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TourPackage[] packages = new TourPackage[10];
        int packageCount = 0;

        Booking[] bookings = new Booking[20];
        int bookingCount = 0;

        // Predefined packages
        packages[packageCount++] = new TourPackage("Kerala", 5000, new String[]{"Alleppey", "Munnar", "Kumarakom"});
        packages[packageCount++] = new TourPackage("Goa", 7000, new String[]{"Calangute", "Baga Beach", "Dudhsagar"});

        System.out.println("==================================================================================");
        System.out.println("                   Welcome to Smart Tourism Booking System");
        System.out.println("==================================================================================\n");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (username.equalsIgnoreCase("admin")) {
            Admin admin = new Admin(username);

            while (true) {
                System.out.println("\n--- Admin Panel ---");
                System.out.println("1. Add Tour Package");
                System.out.println("2. View Bookings");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter destination: ");
                        String dest = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter number of attractions: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        String[] attractions = new String[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Attraction " + (i + 1) + ": ");
                            attractions[i] = scanner.nextLine();
                        }

                        admin.addPackage(packages, packageCount++, dest, price, attractions);
                        break;

                    case 2:
                        admin.viewBookings(bookings, bookingCount);
                        break;

                    case 3:
                        System.out.println("Exiting Admin Panel.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            User user = new User(username);

            while (true) {
                System.out.println("\n--- User Panel ---");
                System.out.println("1. View Tour Packages");
                System.out.println("2. Book a Package");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    user.viewPackages(packages, packageCount);
                } else if (choice == 2) {
                    user.viewPackages(packages, packageCount);
                    System.out.print("Enter package number to book: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    if (num >= 1 && num <= packageCount) {
                        Booking booking = user.bookPackage(scanner, packages[num - 1]);
                        bookings[bookingCount++] = booking;
                    } else {
                        System.out.println("❌ Invalid package number.");
                    }
                } else if (choice == 3) {
                    System.out.println("Exiting User Panel.");
                    return;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }
}
