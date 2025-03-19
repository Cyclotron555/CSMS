
//Claude Butnaru
//Database class
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    // Delete Employee by ID
    public static void deleteEmployee(String _id) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM employee " + "WHERE id = " + _id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Update Employee
    public static void updateEmployee(int _ID, String _position, String _firstName, String _lastName,
            String _address,
            String _city, String _state, String _zip, String _dob,
            String _sex, String _socialSecurity) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            statement.executeUpdate(
                    "UPDATE employee SET " + "id = '" + _ID + "'" + ", "
                            + "position = '" + _position + "'" + ", "
                            + "firstName = '" + _firstName + "'" + ", "
                            + "lastname = '" + _lastName + "'" + ", "
                            + "address = '" + _address + "'" + ", "
                            + "city = '" + _city + "'" + ", "
                            + "state = '" + _state + "'" + ", "
                            + "zip = '" + _zip + "'" + ", "
                            + "dob = '" + _dob + "'" + ", "
                            + "sex = '" + _sex + "'" + ", "
                            + "socialSecurity = '" + _socialSecurity + "'" + ", "
                            + "doe = '" + getDateTime() + "'" + " WHERE id = " + _ID);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Display employee from table employee | this is an array list it displays the
    // employee info into an arrayList as strings
    public static ArrayList<String> displayEmployee() {
        ArrayList<String> employeeList = new ArrayList<String>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            // Query select to display from DB
            ResultSet rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                // read the result set from the employee table and insert into list
                employeeList.add(String.valueOf(rs.getInt("id")));
                employeeList.add(rs.getString("position"));
                employeeList.add(rs.getString("firstName"));
                employeeList.add(rs.getString("lastName"));
                employeeList.add(rs.getString("address"));
                employeeList.add(rs.getString("city"));
                employeeList.add(rs.getString("state"));
                employeeList.add(rs.getString("zip"));
                employeeList.add(rs.getString("dob"));
                employeeList.add(rs.getString("sex"));
                employeeList.add(rs.getString("socialSecurity"));
                employeeList.add(rs.getString("doe"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return employeeList;
    }
}
