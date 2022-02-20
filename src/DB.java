
//Claude Butnaru
//Database class
import javax.swing.*;
import java.sql.*;

//Claude Butnaru

public class DB {
    private static String url = "jdbc:sqlite:mainDB.db";

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters

            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Create table Employees
    public static void createTableEmployees() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
