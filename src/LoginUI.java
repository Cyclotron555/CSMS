
/*
 * Start 2-4-2022 | Claude Butnaru |
 *  In this class the login buttons are created on a grid, this class is called
 * in the main class and and it creates the UI for the first page when a user enters the application
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginUI implements ActionListener {
    private static boolean visibleLogin = false;
    private static JLabel loginTextLabel = new JLabel("Username");
    private static JTextField loginTextfield = new JTextField(20);
    private static JLabel passwordLabel = new JLabel("Password");
    private static JTextField passwordTextfield = new JTextField(20);
    private static JButton loginButton = new JButton("Login");
    public static JLabel mainImageLabel;

    // Constructor
    public static void login() {
        GridBagConstraints grid = new GridBagConstraints();
        GridBagConstraints grid2 = new GridBagConstraints();
        // 3 Buttons on top
        JButton managerButton = new JButton("Manager Login");
        JButton employeeButton = new JButton("Employee Login");
        JButton cashRegisterButton = new JButton("Cash Register");
        // Panel background image
        mainImageLabel = new JLabel(new ImageIcon("./img/frontPageBackground.png"));
        mainImageLabel.setLayout(new GridBagLayout());
        // Manager button
        managerButton.setPreferredSize(new Dimension(160, 40));
        managerButton.setMargin(new Insets(0, 0, 0, 0));
        managerButton.setFont(new Font("Arial", Font.PLAIN, 18));
        // Employee button
        employeeButton.setPreferredSize(new Dimension(160, 40));
        employeeButton.setMargin(new Insets(0, 0, 0, 0));
        employeeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        // Cash register button
        cashRegisterButton.setPreferredSize(new Dimension(160, 40));
        cashRegisterButton.setMargin(new Insets(0, 0, 0, 0));
        cashRegisterButton.setFont(new Font("Arial", Font.PLAIN, 18));

        // Add all to main panel and set main panel grid fill
        // Only show the login page if display number is 0 in main
        Main.mainPanel.add(mainImageLabel, new GridBagConstraints());
        // GRID
        grid2.fill = GridBagConstraints.VERTICAL;
        grid2.fill = GridBagConstraints.HORIZONTAL;
        // Grid layout
        // 3 Buttons on top
        grid.insets = new Insets(25, 5, 5, 5);
        grid.gridx = 0;
        grid.gridy = 0;
        mainImageLabel.add(managerButton, grid);
        grid.gridx = 1;
        grid.gridy = 0;
        mainImageLabel.add(employeeButton, grid);
        grid.gridx = 2;
        grid.gridy = 0;
        mainImageLabel.add(cashRegisterButton, grid);
        // Login on the grid
        grid.gridx = 0;
        grid.gridy = 1;
        mainImageLabel.add(loginTextLabel, grid);
        grid.gridx = 1;
        grid.gridy = 1;
        mainImageLabel.add(loginTextfield, grid);
        // password on the grid
        grid.gridx = 0;
        grid.gridy = 2;
        mainImageLabel.add(passwordLabel, grid);
        grid.gridx = 1;
        grid.gridy = 2;
        mainImageLabel.add(passwordTextfield, grid);
        // Button on the grid
        grid.gridx = 1;
        grid.gridy = 3;
        mainImageLabel.add(loginButton, grid);
        // Action listeners
        managerButton.addActionListener(new LoginUI());
        employeeButton.addActionListener(new LoginUI());
        cashRegisterButton.addActionListener(new LoginUI());
        loginButton.addActionListener(new LoginUI());
        setLoginButtonsVisible();
    }

    // Event handler for all buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        Main main = new Main();
        if (e.getActionCommand().equals("Manager Login")) {
            visibleLogin = true;
            setLoginButtonsVisible();
        } else if (e.getActionCommand().equals("Employee Login")) {
            visibleLogin = true;
            setLoginButtonsVisible();
        } else if (e.getActionCommand().equals("Cash Register")) {
            visibleLogin = true;
            setLoginButtonsVisible();
        } else if (e.getActionCommand().equals("Login")) {
            main.setDisplayNumber(1);
            main.switchUI();
        }
    }

    private static void setLoginButtonsVisible() {
        // Hide login
        if (visibleLogin == false) {
            loginTextLabel.setVisible(false);
            loginTextfield.setVisible(false);
            passwordLabel.setVisible(false);
            passwordTextfield.setVisible(false);
            loginButton.setVisible(false);
        } else if (visibleLogin == true) {
            loginTextLabel.setVisible(true);
            loginTextfield.setVisible(true);
            passwordLabel.setVisible(true);
            passwordTextfield.setVisible(true);
            loginButton.setVisible(true);
            visibleLogin = false;
        }
    }
}
