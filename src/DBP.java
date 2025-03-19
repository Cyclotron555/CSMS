
//Claude Butnaru
//Database for products class
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBP {
    private static String url = "jdbc:sqlite:mainDB.db";

    // Create table Employees
    public static void createTableProducts() {
        // SQL statement create table
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);

            String createTable = "CREATE TABLE IF NOT EXISTS products (" +
                    " id INTEGER PRIMARY KEY autoincrement, " +
                    " categoryName VARCHAR(50) NOT NULL, " +
                    " productName VARCHAR(50) NOT NULL, " +
                    " brand VARCHAR(50) NOT NULL, " +
                    " priceBought DOUBLE NOT NULL, " +
                    " priceSold DOUBLE NOT NULL, " +
                    " description TEXT NOT NULL, " +
                    " dateChanged VARCHAR(50) NOT NULL)";

            statement.executeUpdate(createTable);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Insert new product into table product
    public static void insertProduct(String _categoryName, String _productName, String _brand,
            double _priceBought, double _priceSold, String _description) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            statement.executeUpdate(
                    "insert into products values(null, "
                            + "'" + _categoryName + "'" + ", "
                            + "'" + _productName + "'" + ", "
                            + "'" + _brand + "'" + ", "
                            + "'" + _priceBought + "'" + ", "
                            + "'" + _priceSold + "'" + ", "
                            + "'" + _description + "'" + ", "
                            + "'" + getDateTime() + "'" + ")");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }

    // Display products from table products | this is an array list it displays the
    // product info into an arrayList as strings
    public static ArrayList<String> displayProduct() {
        ArrayList<String> productList = new ArrayList<String>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            // Query select to display from DB
            ResultSet productResult = statement.executeQuery("SELECT * FROM products");
            while (productResult.next()) {
                // read the result set from the employee table and insert into list
                productList.add(String.valueOf(productResult.getInt("id")));
                productList.add(productResult.getString("categoryName"));
                productList.add(productResult.getString("productName"));
                productList.add(productResult.getString("brand"));
                productList.add(String.valueOf(productResult.getDouble("priceBought")));
                productList.add(String.valueOf(productResult.getDouble("priceSold")));
                productList.add(productResult.getString("description"));
                productList.add(productResult.getString("dateChanged"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return productList;
    }

    // Get product categories list
    public static ArrayList<String> getProductCategories() {
        Connection connection = null;
        ArrayList<String> getProductCategories = new ArrayList<String>();
        try {
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);
            ResultSet results = statement.executeQuery("SELECT * FROM products");
            while (results.next()) {
                boolean containsElement = getProductCategories.contains(results.getString("categoryName"));
                if (containsElement == false) {
                    // Capitalize results and add to list of Categories
                    String firstLetter = results.getString("categoryName").substring(0, 1);
                    String remainingLetters = results.getString("categoryName").substring(1);
                    firstLetter = firstLetter.toUpperCase();
                    String finalWord = firstLetter + remainingLetters;
                    getProductCategories.add(finalWord);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Main.mainPanel, e.toString(), "CSMS - DatabaseError",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return getProductCategories;
    }

    private static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String ts = sdf.format(timeStamp);
        return ts;
    }

}
