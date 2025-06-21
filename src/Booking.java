import java.sql.*;
import java.util.ArrayList;

public class Booking {
    String username;
    int packageId;
    String travelDate;
    String duration;

    public Booking(String username, int packageId, String travelDate, String duration) {
        this.username = username;
        this.packageId = packageId;
        this.travelDate = travelDate;
        this.duration = duration;
    }

    public void display() {
        System.out.println("User: " + username + " | Package ID: " + packageId +
                " | Travel: " + travelDate + " for " + duration);
    }

    public int saveAndReturnId(DatabaseCon db) throws SQLException {
        String sql = "INSERT INTO bookings (username, package_id, travel_date, duration) VALUES (?, ?, ?, ?) RETURNING id";
        try (PreparedStatement pst = db.con.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setInt(2, packageId);
            pst.setDate(3, java.sql.Date.valueOf(travelDate));
            pst.setString(4, duration);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    public static ArrayList<Booking> fetchAllBookings(DatabaseCon db) throws SQLException {
        ArrayList<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";
        try (Statement stmt = db.con.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                bookings.add(new Booking(
                    rs.getString("username"),
                    rs.getInt("package_id"),
                    rs.getDate("travel_date").toString(),
                    rs.getString("duration")
                ));
            }
        }
        return bookings;
    }
}
