public class Hotel {
    String[] roomTypes = { "Single Room", "Double Room", "Twin Room", "Deluxe Room", "Suite" };

    public void displayHotelOptions() {
        System.out.println("\nHotel Room Options:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i]);
        }
    }
}
