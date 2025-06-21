import java.sql.*;

public class TourPackage {
    String destination;
    double price;
    String[] attractions;

    public TourPackage(String destination, double price, String[] attractions) {
        this.destination = destination;
        this.price = price;
        this.attractions = attractions;
    }

    public void saveToDB(DatabaseCon db) throws SQLException {
        Connection con = db.con;
        String sql = "INSERT INTO tour_packages (destination, price) VALUES (?, ?) RETURNING id";
        int packageId = -1;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, destination);
            ps.setDouble(2, price);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                packageId = rs.getInt("id");
            }
        }

        for (String place : attractions) {
            String sql2 = "INSERT INTO attractions (package_id, attraction) VALUES (?, ?)";
            try (PreparedStatement ps2 = con.prepareStatement(sql2)) {
                ps2.setInt(1, packageId);
                ps2.setString(2, place);
                ps2.executeUpdate();
            }
        }
    }

    public static void fetchAll(DatabaseCon db) throws SQLException {
        Connection con = db.con;
        String sql = "SELECT tp.id, tp.destination, tp.price, array_agg(a.attraction) AS places " +
                     "FROM tour_packages tp LEFT JOIN attractions a ON tp.id = a.package_id " +
                     "GROUP BY tp.id, tp.destination, tp.price";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("destination") + " - ₹" + rs.getDouble("price"));
                System.out.println("Attractions:");
                Array places = rs.getArray("places");
                String[] placesArr = (String[]) places.getArray();
                for (String p : placesArr) {
                    System.out.println(" - " + p);
                }
            }
        }
    }
}
