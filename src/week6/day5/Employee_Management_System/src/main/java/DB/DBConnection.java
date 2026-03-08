package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5436/mydatabase", "myuser",
                        "mypassword");
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
                return null;
            }
        }
        return conn;
    }
}
