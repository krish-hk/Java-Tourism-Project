public class TourPackage {
    String destination;
    double price;
    String[] attractions;

    public TourPackage(String destination, double price, String[] attractions) {
        this.destination = destination;
        this.price = price;
        this.attractions = attractions;
    }

    public void displayDetails() {
        System.out.println(destination + " - ₹" + price);
        System.out.println("Attractions:");
        for (String place : attractions) {
            System.out.println(" - " + place);
        }
    }
}
