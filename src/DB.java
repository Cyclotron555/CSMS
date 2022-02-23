
//Claude Butnaru
//Database class
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

//Claude Butnaru

public class DB {
    private static String url = "jdbc:sqlite:mainDB.db";

    private static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String ts = sdf.format(timeStamp);
        return ts;
    }

    // Create table Employees
    public static void createTableEmployee() {
        // SQL statement for creating a new table
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);

            ///////////////////// Delete////////////////////////////
            String sql = "DROP TABLE employee";
            statement.executeUpdate(sql);
            ///////////////////// Delete////////////////////////////

            String createTable = "CREATE TABLE IF NOT EXISTS employee (" +
                    " id INTEGER PRIMARY KEY autoincrement, " +
                    " position VARCHAR(50) NOT NULL, " +
                    " firstName VARCHAR(50) NOT NULL, " +
                    " lastName VARCHAR(50) NOT NULL, " +
                    " address VARCHAR(50) NOT NULL, " +
                    " city VARCHAR(50) NOT NULL, " +
                    " state VARCHAR(50) NOT NULL, " +
                    " zip VARCHAR(10) NOT NULL, " +
                    " dob VARCHAR(20) NOT NULL, " +
                    " sex VARCHAR(2) NOT NULL, " +
                    " socialSecurity VARCHAR(20) NOT NULL, " +
                    " doe VARCHAR(50) NOT NULL)";

            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Insert new employee into table employee
    public static void insertEmployee(String _position, String _firstName, String _lastName, String _address,
            String _city, String _state, String _zip, String _dob,
            String _sex, String _socialSecurity) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            statement.executeUpdate(
                    "insert into employee values(null, "
                            + "'" + _position + "'" + ", "
                            + "'" + _firstName + "'" + ", "
                            + "'" + _lastName + "'" + ", "
                            + "'" + _address + "'" + ", "
                            + "'" + _city + "'" + ", "
                            + "'" + _state + "'" + ", "
                            + "'" + _zip + "'" + ", "
                            + "'" + _dob + "'" + ", "
                            + "'" + _sex + "'" + ", "
                            + "'" + _socialSecurity + "'" + ", "
                            + "'" + getDateTime() + "'" + ")");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Display employee from table employee
    public static void displayEmployee() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            // Query select to display from DB
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                // read the result set
                System.out.println("ID = " + rs.getInt("id"));
                System.out.println("Position = " + rs.getString("position"));
                System.out.println("First Name = " + rs.getString("firstName"));
                System.out.println("Last Name = " + rs.getString("lastName"));
                System.out.println("Address = " + rs.getString("address"));
                System.out.println("City = " + rs.getString("city"));
                System.out.println("State = " + rs.getString("state"));
                System.out.println("Zip = " + rs.getString("zip"));
                System.out.println("DOB = " + rs.getString("dob"));
                System.out.println("Sex = " + rs.getString("sex"));
                System.out.println("Social Security = " + rs.getString("socialSecurity"));
                System.out.println("Employed since = " + rs.getString("doe"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
}
