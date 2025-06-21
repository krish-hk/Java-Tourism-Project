import java.sql.*;

public class DatabaseCon {
    public Connection con;

    public DatabaseCon() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Tourism", "postgres", "kicha279131"
            );
        } catch (Exception e) {
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
