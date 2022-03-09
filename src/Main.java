// Claude Butnaru
// CSMS

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Use SplitPane for database

class Main {
  // Class level VARS BEGIN
  JFrame window = new JFrame("CSMS - Convenience Store Management System by Claude Butnaru");
  public static JPanel mainPanel = new JPanel();
  public static JToolBar buttonToolBar = new JToolBar();
  JMenuBar menuBar = new JMenuBar();
  Color panelColor = new Color(33, 33, 33);
  JSeparator separator1 = new JSeparator();
  JSeparator separator2 = new JSeparator();
  public static int X, Y;
  public static GridBagConstraints mainGrid = new GridBagConstraints();
  private static AButton displayEmployeesBtn;
  private static AButton addEmployeeBtn;
  private static AButton editEmployeeBtn;
  private static AButton deleteEmployeeBtn;
  private static AButton insertProductBtn;
  private static AButton deleteProductBtn;
  // Class level VARS END

  // Main method is here
  // <<--------------------------------------------------------
  public static void main(String[] args) {
    // DB.connect();
    DB.createTableEmployee();
    DB.displayEmployee();
    setLookAndFeelTheme();
    Main main = new Main();
    main.setPanelsRules();
    setButtonToolBarRules();
    main.setWindowRules();
    main.addComponnents();
    main.menu();
    main.refresh();
  }

  // Panel rules
  private void setPanelsRules() {
    mainPanel.setOpaque(true);
    mainPanel.setBackground(panelColor);
    mainPanel.setBorder(BorderFactory.createEmptyBorder());
    mainPanel.setLayout(new GridBagLayout());
    mainGrid.fill = GridBagConstraints.BOTH;
    mainGrid.weightx = 0;
    mainGrid.weighty = 0;
    mainGrid.insets = new Insets(0, 0, 250, 0);

    // Resize panel on window resize ev. handler | Sets the main panel size same as
    // the window
    window.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        X = (int) (e.getComponent().getSize().getWidth());
        Y = (int) (e.getComponent().getSize().getHeight());
        mainPanel.setBounds(0, 0, X, Y);
        refresh();
        window.setLocationRelativeTo(null);
      }
    });
  }

  private static void setButtonToolBarRules() {
    buttonToolBar.setBackground(new Color(24, 24, 24));
    buttonToolBar.setPreferredSize(new Dimension(X, 64));
    buttonToolBar.setBorder(BorderFactory.createEmptyBorder());
    displayEmployeesBtn = new AButton(new ImageIcon("./img/employees.png"), "All Employees");
    buttonToolBar.add(displayEmployeesBtn);
    addEmployeeBtn = new AButton(new ImageIcon("./img/insertPeople.png"), "Add New Employee");
    buttonToolBar.add(addEmployeeBtn);
    editEmployeeBtn = new AButton(new ImageIcon("./img/editPeople.png"), "Edit Employee");
    buttonToolBar.add(editEmployeeBtn);
    deleteEmployeeBtn = new AButton(new ImageIcon("./img/deletePeople.png"), "Remove Employee");
    buttonToolBar.add(deleteEmployeeBtn);
    insertProductBtn = new AButton(new ImageIcon("./img/insertProduct.png"), "Insert Product");
    buttonToolBar.add(insertProductBtn);
    deleteProductBtn = new AButton(new ImageIcon("./img/deleteProduct.png"), "Delete Product");
    buttonToolBar.add(deleteProductBtn);
    displayEmployeesBtn.setEnabled(false);
    addEmployeeBtn.setEnabled(false);
    editEmployeeBtn.setEnabled(false);
    deleteEmployeeBtn.setEnabled(false);
    insertProductBtn.setEnabled(false);
    deleteProductBtn.setEnabled(false);
  }

  public static void enableAllButtons() {
    displayEmployeesBtn.setEnabled(true);
    addEmployeeBtn.setEnabled(true);
    editEmployeeBtn.setEnabled(true);
    deleteEmployeeBtn.setEnabled(true);
    insertProductBtn.setEnabled(true);
    deleteProductBtn.setEnabled(true);
  }

  // Frame/window rules + frame icon
  private void setWindowRules() {
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    window.setMinimumSize(new Dimension(980, 551));
    window.setResizable(true);
    Image icon = Toolkit.getDefaultToolkit().getImage("./img/mainIcon.png");
    window.setIconImage(icon);
  }

  // Top menu bar (File, Edit etc)
  private void menu() {
    int w = 50;
    int h = 20;
    // Menu Titles
    JMenu fileMenu = new JMenu("File");
    fileMenu.setPreferredSize(new Dimension(w, h));
    JMenu editMenu = new JMenu("Edit");
    editMenu.setPreferredSize(new Dimension(w, h));
    JMenu imageMenu = new JMenu("Image");
    imageMenu.setPreferredSize(new Dimension(w + 7, h));
    JMenu windowMenu = new JMenu("Window");
    windowMenu.setPreferredSize(new Dimension(w + 17, h));
    JMenu helpMenu = new JMenu("Help");
    helpMenu.setPreferredSize(new Dimension(w, h));

    // Add menus
    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(imageMenu);
    menuBar.add(windowMenu);
    menuBar.add(helpMenu);
    menuBar.setPreferredSize(new Dimension(menuBar.getWidth(), 34));

    // File menu
    w = 240;
    h = 30;
    JMenuItem newProduct = new JMenuItem("New Product");
    JMenuItem newEmployee = new JMenuItem("New Employee");
    JMenuItem openProduct = new JMenuItem("Open Product");
    JMenuItem openEmployee = new JMenuItem("Open Employee");
    JMenuItem deleteProduct = new JMenuItem("Delete Product");
    JMenuItem deleteEmployee = new JMenuItem("Delete Employee");
    JMenuItem exportFile = new JMenuItem("Export file");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem closeAll = new JMenuItem("Close All");
    JMenuItem exit = new JMenuItem("Exit");

    /*
     * newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
     * InputEvent.CTRL_DOWN_MASK));
     * openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
     * InputEvent.CTRL_DOWN_MASK));
     * openRecentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
     * InputEvent.CTRL_DOWN_MASK));
     * saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
     * InputEvent.CTRL_DOWN_MASK));
     * saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
     * InputEvent.CTRL_DOWN_MASK));
     * importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
     * InputEvent.CTRL_DOWN_MASK));
     * exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
     * InputEvent.CTRL_DOWN_MASK));
     * closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
     * InputEvent.CTRL_DOWN_MASK));
     * closeAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
     * InputEvent.CTRL_DOWN_MASK));
     * exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
     * InputEvent.CTRL_DOWN_MASK));
     */

    fileMenu.add(newProduct);
    fileMenu.add(newEmployee);
    fileMenu.add(separator1);
    fileMenu.add(openProduct);
    fileMenu.add(openEmployee);
    fileMenu.add(separator2);
    fileMenu.add(deleteProduct);
    fileMenu.add(deleteEmployee);
    fileMenu.add(exportFile);
    fileMenu.add(close);
    fileMenu.add(closeAll);
    fileMenu.add(exit);

    // Set size and space of menu items
    for (int i = 0; i < fileMenu.getMenuComponentCount(); i++) {
      if (!fileMenu.getMenuComponent(i).equals(separator1)
          && !fileMenu.getMenuComponent(i).equals(separator2)) {
        fileMenu.getMenuComponent(i).setPreferredSize(new Dimension(270, 30));
        System.out.println(fileMenu.getMenuComponent(i));
      }
    }
  }

  private void addComponnents() {
    window.add(mainPanel);
    window.add(buttonToolBar, BorderLayout.NORTH);
    window.setVisible(true);
    window.setJMenuBar(menuBar);
    refresh();
    LoginUI.setDisplayNumber(0);
    switchUI();
  }

  private void refresh() {
    window.revalidate();
    window.repaint();
    window.setVisible(true);
  }

  // Switching the UI happens here
  public void switchUI() {
    if (LoginUI.getDisplayNumber() == 0) {
      LoginUI.login();
      refresh();
      return;
    }
    if (LoginUI.getDisplayNumber() == 1) {
      mainPanel.remove(LoginUI.mainImageLabel);
      // ManagerUI class is called here
      ManagerUI.managerData();
      mainPanel.add(ManagerUI.tab);
      mainPanel.revalidate();
      mainPanel.repaint();
      return;
    }
    if (LoginUI.getDisplayNumber() == 2) {
      mainPanel.remove(LoginUI.mainImageLabel);
      EmployeeUI.employeeData();
      mainPanel.add(EmployeeUI.tab1);
      mainPanel.revalidate();
      mainPanel.repaint();
      return;
    }
  }

  // Set Theme
  private static void setLookAndFeelTheme() {
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      // Changes the drop-down menu border
      UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 1));
      UIManager.put("Menu.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 0));
      UIManager.put("MenuBar.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 1));
      UIManager.put("Menu.foreground", new Color(200, 200, 200));
      UIManager.put("Menu.font", new Font("Sans Serif", Font.PLAIN, 12));
      UIManager.put("MenuBar.foreground", new Color(200, 200, 200));
      UIManager.put("MenuBar.background", new Color(30, 30, 30));
      UIManager.put("MenuBar.font", new Font("Sans Serif", Font.PLAIN, 18));
      UIManager.put("Separator.background", new Color(15, 15, 15));
      UIManager.put("Separator.foreground", new Color(25, 25, 25));
      UIManager.put("MenuItem.background", new Color(30, 30, 30));
      UIManager.put("MenuItem.foreground", new Color(200, 200, 200));
      UIManager.put("MenuItem.border", BorderFactory.createLineBorder(new Color(7, 7, 7), 0));

    } catch (Exception e) {
      JOptionPane.showMessageDialog(mainPanel, e.toString(), "CSMS - Display Error", JOptionPane.ERROR_MESSAGE);
    }
    JFrame.setDefaultLookAndFeelDecorated(true);
  }
}
