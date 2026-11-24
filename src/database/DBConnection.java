
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hospital_db";

    private static final String USER = "root";

    // Replace with your MySQL root password
    private static final String PASSWORD = "dbms";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

        } catch (ClassNotFoundException e) {

            throw new SQLException(
                    "MySQL JDBC Driver not found!", e
            );
        }
    }

    public static void main(String[] args) {

        try (Connection con = getConnection()) {

            System.out.println(
                    "Hospital Database Connected Successfully!"
            );

        } catch (SQLException e) {

            System.out.println("Database Connection Failed!");
            System.out.println(e.getMessage());
        }
    }
}
