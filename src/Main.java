import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 

public class Main
{
    //Class globals
    JFrame window = new JFrame("CSMS - Convenience Store Management System by Claude Butnaru");
    JPanel panel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    Color panelColor = new Color(25, 25, 25);
    Color menuTextColor = new Color(200, 200, 200);
    JSeparator separator1 = new JSeparator();    
    JSeparator separator2 = new JSeparator();
    Database database = new Database();
    
    double X, Y;
    public static void main(String[] args)
    {
        setNimbusDarkTheme();
        Main main = new Main(); 
        main.setRules();
        main.addComponnents();
        main.menu();
        main.database.connect();
    }

private void setRules()
{
//Frame rules + frame icon
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setSize(740, 460);
window.setResizable(true);
window.setLayout(null);
window.setUndecorated(false);
Image icon = Toolkit.getDefaultToolkit().getImage("pixelpro.png"); 
window.setIconImage(icon);
//Panel rules
panel.setBounds(0, 0, 740, 460);    
panel.setOpaque(true);
panel.setBackground(panelColor);
panel.setLayout(null);
//MenuBar rules
//menuBar.setBackground(panelColor);
//menuBar.border(Color.BLACK);
}

//Top menu
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
        JMenuItem newItem = new JMenuItem("New Item");
        newItem.setPreferredSize(new Dimension(w, h));
        newItem.setForeground(menuTextColor);
        newItem.setBackground(panelColor);

        JMenuItem openItem = new JMenuItem("New Employee");
        openItem .setPreferredSize(new Dimension(w, h));
        openItem.setForeground(menuTextColor);
        openItem.setBackground(panelColor);

        JMenuItem openRecentItem = new JMenuItem("Open Item");
        openRecentItem.setPreferredSize(new Dimension(w, h));
        openRecentItem.setForeground(menuTextColor);
        openRecentItem.setBackground(panelColor);

        JMenuItem saveItem = new JMenuItem("Open Employee");
        saveItem.setPreferredSize(new Dimension(w, h));
        saveItem.setForeground(menuTextColor);
        saveItem.setBackground(panelColor);

        JMenuItem saveAsItem = new JMenuItem("Save As");
        saveAsItem.setPreferredSize(new Dimension(w, h));
        saveAsItem.setForeground(menuTextColor);
        saveAsItem.setBackground(panelColor);

        JMenuItem importItem = new JMenuItem("Import");
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
       

        //Resize panel on window resize ev. handler
        window.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
              X = e.getComponent().getSize().getWidth();
              Y = e.getComponent().getSize().getHeight();
              panel.setBounds(0, 0, (int)X, (int)Y);
            }
          });
    }

private void addComponnents()
{
    window.add(panel);
    window.setVisible(true);
    window.setJMenuBar(menuBar);
    window.invalidate();
    window.validate();
    window.repaint();
    window.setVisible(true);
}

//Set Nimbus Dark Theme
private static void setNimbusDarkTheme()
{
  UIManager.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.YELLOW));
  UIManager.put( "control", new Color( 50, 50, 50) );
  UIManager.put( "info", new Color(50, 50, 50) );
  UIManager.put( "nimbusBase", new Color( 0, 0, 0) );
  UIManager.put( "nimbusBlueGrey", new Color(0, 0, 0) );
  UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 100) );
  UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
  UIManager.put( "nimbusFocus", new Color(10,10,10) );
  UIManager.put( "nimbusGreen", new Color(176,179,50) );
  UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
  UIManager.put( "nimbusLightBackground", new Color( 10, 10, 10) );
  UIManager.put( "nimbusOrange", new Color(191,98,4) );
  UIManager.put( "nimbusRed", new Color(169,46,34) );
  UIManager.put( "nimbusSelectedText", new Color( 10, 10, 10) );
  UIManager.put( "nimbusSelectionBackground", new Color( 10, 10, 10) );
  UIManager.put( "text", new Color( 200, 200, 200) );
  //change titlebar color
  Main main = new Main();  
  main.window.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(23,180,252));
  main.window.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
    try 
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
      {
        if ("Nimbus".equals(info.getName())) 
        {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
      }
    } 
    catch (ClassNotFoundException e) 
    {
      e.printStackTrace();
    } 
    catch (InstantiationException e) 
    {
      e.printStackTrace();
    } 
    catch (IllegalAccessException e) 
    {
      e.printStackTrace();
    } 
    catch (javax.swing.UnsupportedLookAndFeelException e) 
    {
      e.printStackTrace();
    } 
    catch (Exception e) 
    {
      e.printStackTrace();
    }
    
}
}