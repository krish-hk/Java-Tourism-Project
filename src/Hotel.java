import java.sql.*;

public class Hotel {
    public String[] roomTypes = { "Single Room", "Double Room", "Twin Room", "Deluxe Room", "Suite" };

    String roomType;
    int roomCount;
    String checkIn;
    String checkOut;
    int bookingId;

    public Hotel() { }

    public Hotel(String roomType, int roomCount, String checkIn, String checkOut, int bookingId) {
        this.roomType = roomType;
        this.roomCount = roomCount;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingId = bookingId;
    }

    public void displayHotelOptions() {
        System.out.println("\nHotel Room Options:");
        for (int i = 0; i < roomTypes.length; i++) {
            System.out.println((i + 1) + ". " + roomTypes[i]);
        }
    }

    public void saveToDB(DatabaseCon db) throws SQLException {
        String sql = "INSERT INTO hotel_bookings (booking_id, room_type, room_count, check_in, check_out) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = db.con.prepareStatement(sql)) {
            ps.setInt(1, bookingId);
            ps.setString(2, roomType);
            ps.setInt(3, roomCount);
            ps.setDate(4, java.sql.Date.valueOf(checkIn));
            ps.setDate(5, java.sql.Date.valueOf(checkOut));
            ps.executeUpdate();
        }
    }
}
