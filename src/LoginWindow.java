/*
Start 2-4-2022
Claude Butnaru
In this class the login buttons are created, this class is called in the main class and
and it creates the UI for the first page when a user enters the application
*/
import javax.swing.JButton; 

class LoginWindow
{
    //Constructor
    public static void login()
    {
        Main mainWindow = new Main();
        JButton managerButton = new JButton("Login as Manager");
        mainWindow.mainPanel.add(managerButton);
    }
}
