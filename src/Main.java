//Claude Butnaru

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
import java.awt.FlowLayout;

class Main
{
    //Class level VARS BEGIN
    JFrame window = new JFrame("CSMS - Convenience Store Management System by Claude Butnaru");
    public JPanel mainPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    Color panelColor = new Color(33, 33, 33);
    Color menuTextColor = new Color(200, 200, 200);
    JSeparator separator1 = new JSeparator();    
    JSeparator separator2 = new JSeparator();
    //Class level VARS END
    
    double X, Y;
    //Main method is here <<--------------------------------------------------------
    public static void main(String[] args)
    {
        setLookAndFeelTheme();
        Main main = new Main(); 
        main.setRules();
        main.addComponnents();
        main.menu();
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.login();
        Database.connect();
    }

private void setRules()
{
//Frame rules + frame icon
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setMinimumSize(new Dimension(1280, 720));
window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
window.setResizable(true);
window.setLayout(null);
window.setUndecorated(true);
Image icon = Toolkit.getDefaultToolkit().getImage("./img/mainIcon.png"); 
window.setIconImage(icon);
//Panel rules  
mainPanel.setOpaque(true);
mainPanel.setBackground(panelColor);
mainPanel.setLayout(new FlowLayout());
//Resize panel on window resize ev. handler | Sets the main panel size same as the window
window.addComponentListener(new ComponentAdapter() {
  @Override
  public void componentResized(ComponentEvent e) {
    X = e.getComponent().getSize().getWidth();
    Y = e.getComponent().getSize().getHeight();
    mainPanel.setBounds(0, 0, (int)X, (int)Y);
    refresh();
  }
});

//MenuBar rules
menuBar.setBackground(panelColor);
//menuBar.borderColor(Color.BLACK);
}

//Top menu bar (File, Edit etc)
private void menu()
    {
      int w = 50;
      int h = 20;
        //Menu Titles
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        fileMenu.setForeground(menuTextColor);
        fileMenu.setPreferredSize(new Dimension(w, h));
        JMenu editMenu = new JMenu("Edit");
        editMenu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        editMenu.setForeground(menuTextColor);
        editMenu.setPreferredSize(new Dimension(w, h));
        JMenu imageMenu = new JMenu("Image");
        imageMenu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        imageMenu.setForeground(menuTextColor);
        imageMenu.setPreferredSize(new Dimension(w+7, h));
        JMenu windowMenu = new JMenu("Window");
        windowMenu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        windowMenu.setForeground(menuTextColor);
        windowMenu.setPreferredSize(new Dimension(w+17, h));
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        helpMenu.setForeground(menuTextColor);
        helpMenu.setPreferredSize(new Dimension(w, h));

        //Menus rules

        //Add menus
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(imageMenu);
        menuBar.add(windowMenu);
        menuBar.add(helpMenu);
        menuBar.setPreferredSize(new Dimension(menuBar.getWidth(), 34 ));

        //File menu
        w = 240;
        h = 30;
        JMenuItem newItem = new JMenuItem("New Product");
        newItem.setPreferredSize(new Dimension(w, h));
        newItem.setForeground(menuTextColor);
        newItem.setBackground(panelColor);

        JMenuItem openItem = new JMenuItem("New Employee");
        openItem .setPreferredSize(new Dimension(w, h));
        openItem.setForeground(menuTextColor);
        openItem.setBackground(panelColor);

        JMenuItem openRecentItem = new JMenuItem("Open Product");
        openRecentItem.setPreferredSize(new Dimension(w, h));
        openRecentItem.setForeground(menuTextColor);
        openRecentItem.setBackground(panelColor);

        JMenuItem saveItem = new JMenuItem("Open Employee");
        saveItem.setPreferredSize(new Dimension(w, h));
        saveItem.setForeground(menuTextColor);
        saveItem.setBackground(panelColor);

        JMenuItem saveAsItem = new JMenuItem("Delete Product");
        saveAsItem.setPreferredSize(new Dimension(w, h));
        saveAsItem.setForeground(menuTextColor);
        saveAsItem.setBackground(panelColor);

        JMenuItem importItem = new JMenuItem("Delete Employee");
        importItem.setPreferredSize(new Dimension(w, h));
        importItem.setForeground(menuTextColor);
        importItem.setBackground(panelColor);

        JMenuItem exportItem = new JMenuItem("Export");
        exportItem.setPreferredSize(new Dimension(w, h));
        exportItem.setForeground(menuTextColor);
        exportItem.setBackground(panelColor);

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.setPreferredSize(new Dimension(w, h));
        closeItem.setForeground(menuTextColor);
        closeItem.setBackground(panelColor);

        JMenuItem closeAllItem = new JMenuItem("Close All");
        closeAllItem.setPreferredSize(new Dimension(w, h));
        closeAllItem.setForeground(menuTextColor);
        closeAllItem.setBackground(panelColor);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setPreferredSize(new Dimension(w, h));
        exitItem.setForeground(menuTextColor);
        exitItem.setBackground(panelColor);

        //separator1.setForeground(new Color(200, 200, 200));
        //separator2.setForeground(menuTextColor);
        /*
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openRecentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        closeAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        */

        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(separator1);
        fileMenu.add(openRecentItem);
        fileMenu.add(saveItem);
        fileMenu.add(separator2);
        fileMenu.add(saveAsItem);
        fileMenu.add(importItem);
        fileMenu.add(exportItem);
        fileMenu.add(closeItem);
        fileMenu.add(closeAllItem);
        fileMenu.add(exitItem);
    }

private void addComponnents()
{
    
    window.add(mainPanel);
    window.setVisible(true);
    window.setJMenuBar(menuBar);
    refresh();
}

private void refresh()
{
  window.invalidate();
  window.validate();
  window.repaint();
  window.setVisible(true);
}

//Set Nimbus Dark Theme
private static void setLookAndFeelTheme()
{
  try 
  {
    UIManager.setLookAndFeel(
    UIManager.getCrossPlatformLookAndFeelClassName());
    //Changes the drop-down menu border
    UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 1));
    UIManager.put("MenuBar.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 1));
    UIManager.put("Menu.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 0));
    UIManager.put("MenuItem.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 0));
    UIManager.put("MenuBar.foreground", new Color(7, 7, 7));
    UIManager.put("MenuBar.background", new Color(30, 30, 30));
    UIManager.put("Separator.background", new Color(15, 15, 15));
    UIManager.put("Separator.foreground", new Color(25, 25, 25));

 }
  catch (Exception e) 
  { 
  }
 JFrame.setDefaultLookAndFeelDecorated(true); 
}
}