CSMS - Claude's Store Management System

Overview

CSMS (Claude's Store Management System) is a Java Swing application designed from scratch, without any templates or drag-and-drop tools. The system is developed entirely in VS Code, using pure Java code for both the UI and backend. CSMS provides a retro-styled UI reminiscent of classic Windows designs and supports SQLite as its database for data storage.

Features

🎨 Custom Java Swing UI (No templates, fully coded)

🖥 Grid-based dynamic UI layout for flexible resizing

🔑 Login system for Managers and Employees

📦 SQLite Database Integration

📋 Employee & Product Management

📊 Inventory tracking system

🔢 Built-in calculator for financial operations

🔄 Event-driven UI elements with interactive buttons

🏆 Custom reusable UI components (JToolbar, EmployeeLabel, etc.)

Technologies Used

Java (Swing for UI, JDBC for database)

SQLite (Embedded Database)

Maven (For project management)

Database Configuration

CSMS uses SQLite as a local database. The connection is established via JDBC.
Example method to create an Employee table:

public static void createTableEmployees() {
String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
+ " id integer PRIMARY KEY,\n"
+ " name text NOT NULL,\n"
+ " position text NOT NULL,\n"
+ " salary real NOT NULL\n"
+ ");";

    try (Connection conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement()) {
        stmt.execute(sql);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

Running the Application

Clone the repository:

git clone https://github.com/Cyclotron555/CSMS.git
cd CSMS

Build and run:

mvn clean install
java -jar CSMS.jar

Application Flow

Startup: Displays a main menu with Manager & Employee login options.

Login: Based on role, the UI switches between ManagerUI and EmployeeUI.

Dashboard:

Employees: View, add, modify, and delete employees.

Products: Manage inventory and categories.

Calculator: Integrated financial tool.

Dynamic UI Updates: Components dynamically refresh when data changes.

Future Enhancements

📌 POS System Integration

📊 Advanced reporting tools

🌐 Online syncing & cloud database

🔄 Automated payroll system

Contributing

Feel free to fork the repository, submit pull requests, or open issues for feature requests and improvements!

License

This project is licensed under the MIT License.


