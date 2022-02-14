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
  public static JPanel buttonPanel = new JPanel();
  JMenuBar menuBar = new JMenuBar();
  Color panelColor = new Color(33, 33, 33);
  JSeparator separator1 = new JSeparator();
  JSeparator separator2 = new JSeparator();
  int displayNumber;
  // Class level VARS END

  public static int X, Y;

  // Main method is here
  // <<--------------------------------------------------------
  public static void main(String[] args)
  {
    setLookAndFeelTheme();
    Main main = new Main();
    main.setPanelsRules();
    main.setWindowRules();
    main.addComponnents();
    main.menu();
    DB.connect();
    main.refresh();
  }

  // Panel rules
  private void setPanelsRules()
  {
    mainPanel.setOpaque(true);
    buttonPanel.setOpaque(true);
    mainPanel.setBackground(panelColor);
    buttonPanel.setBackground(new Color(28, 28, 28));
    buttonPanel.setBorder(BorderFactory.createLineBorder(new Color(10, 10, 10)));
    mainPanel.setLayout(new GridBagLayout());
    // Resize panel on window resize ev. handler | Sets the main panel size same as
    // the window
    window.addComponentListener(new ComponentAdapter()
    {
      @Override
      public void componentResized(ComponentEvent e)
      {
        X = (int)(e.getComponent().getSize().getWidth());
        Y = (int)(e.getComponent().getSize().getHeight());
        mainPanel.setBounds(0, 30, X, Y);
        buttonPanel.setBounds(0, 0, X, 30);
        refresh();
        window.setLocationRelativeTo(null);
      }
    });
  }

  // Frame/window rules + frame icon
  private void setWindowRules()
  {
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setExtendedState(JFrame.MAXIMIZED_BOTH);
    window.setMinimumSize(new Dimension(980, 551));
    window.setResizable(true);
    Image icon = Toolkit.getDefaultToolkit().getImage("./img/mainIcon.png");
    window.setIconImage(icon);
  }

  // Top menu bar (File, Edit etc)
  private void menu()
  {
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
     * newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
     * openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
     * openRecentItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
     * InputEvent.CTRL_DOWN_MASK)); saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
     * InputEvent.CTRL_DOWN_MASK)); saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
     * InputEvent.CTRL_DOWN_MASK)); importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
     * InputEvent.CTRL_DOWN_MASK)); exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
     * InputEvent.CTRL_DOWN_MASK)); closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
     * InputEvent.CTRL_DOWN_MASK));
     * closeAllItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
     * InputEvent.CTRL_DOWN_MASK)); exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
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
    for (int i = 0; i < fileMenu.getMenuComponentCount(); i++)
    {
      if (!fileMenu.getMenuComponent(i).equals(separator1)
          && !fileMenu.getMenuComponent(i).equals(separator2))
      {
        fileMenu.getMenuComponent(i).setPreferredSize(new Dimension(270, 30));
        System.out.println(fileMenu.getMenuComponent(i));
      }
    }
  }

  private void addComponnents()
  {
    window.add(buttonPanel);
    window.add(mainPanel);
    window.setVisible(true);
    window.setJMenuBar(menuBar);
    refresh();
    displayNumber = 0;
    switchUI();
  }

  private void refresh()
  {
    window.revalidate();
    window.repaint();
    window.setVisible(true);
  }
//Switching the UI happens here
  public void switchUI()
  {
    if (displayNumber == 0)
    {
      LoginUI.login();
      refresh();
    }
    if (displayNumber == 1)
    {
      mainPanel.remove(LoginUI.mainImageLabel);
      ManagerUI.managerData();
      mainPanel.revalidate();
      mainPanel.repaint();
    }
  }
  public void setDisplayNumber(int _displayNumber)
  {
    this.displayNumber = _displayNumber;
  }
  public int getDisplayNumber()
  {
    return this.displayNumber;
  }

  // Set Theme
  private static void setLookAndFeelTheme()
  {
    try
    {
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

    } catch (Exception e)
    {
    }
    JFrame.setDefaultLookAndFeelDecorated(true);
  }
}
