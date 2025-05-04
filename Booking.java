public class Booking {
    String username;
    String packageName;
    String travelDate;
    String duration;
    String roomType;
    int roomCount;
    String checkIn;
    String checkOut;

    public Booking(String username, String packageName, String travelDate, String duration,
                   String roomType, int roomCount, String checkIn, String checkOut) {
        this.username = username;
        this.packageName = packageName;
        this.travelDate = travelDate;
        this.duration = duration;
        this.roomType = roomType;
        this.roomCount = roomCount;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void display() {
        System.out.println("User: " + username + " | Package: " + packageName + 
            " | Travel: " + travelDate + " for " + duration +
            " | Room: " + roomType + " x " + roomCount +
            " | Stay: " + checkIn + " to " + checkOut);
    }
}
