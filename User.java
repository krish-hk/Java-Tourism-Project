import java.util.Scanner;

public class User {
    String username;

    public User(String username) {
        this.username = username;
    }

    public void viewPackages(TourPackage[] packages, int count) {
        System.out.println("\n--- Tour Packages ---");
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + ". ");
            packages[i].displayDetails();
        }
    }

    public Booking bookPackage(Scanner scanner, TourPackage selectedPackage) {
        System.out.print("Enter date of travel: ");
        String travelDate = scanner.nextLine();
        System.out.print("Enter duration (e.g., 3 days): ");
        String duration = scanner.nextLine();

        System.out.println("\nMain Tourist Attractions in " + selectedPackage.destination + ":");
        for (String place : selectedPackage.attractions) {
            System.out.println(" - " + place);
        }

        System.out.print("\nDo you want to check room options? (yes/no): ");
        String hotelChoice = scanner.nextLine();
        String roomType = "None", checkIn = "-", checkOut = "-";
        int roomCount = 0;

        if (hotelChoice.equalsIgnoreCase("yes")) {
            Hotel hotel = new Hotel();
            hotel.displayHotelOptions();

            System.out.print("Choose room type (1-5): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            roomType = hotel.roomTypes[type - 1];

            System.out.print("Enter number of rooms: ");
            roomCount = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter check-in date: ");
            checkIn = scanner.nextLine();
            System.out.print("Enter check-out date: ");
            checkOut = scanner.nextLine();
        }

        System.out.println("✅ Booking completed!");
        return new Booking(username, selectedPackage.destination, travelDate, duration,
                roomType, roomCount, checkIn, checkOut);
    }
}
