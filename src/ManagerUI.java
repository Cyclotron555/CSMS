
//Claude Butnaru
//ManagerWindow class. After login this window is displayed to the manager
import javax.swing.*;
import java.awt.*;

public class ManagerUI {
    public static JTabbedPane tab = new JTabbedPane();

    public static void managerData() {

        Main.mainPanel.setLayout(new BorderLayout());
        employeeTab();
        productsTab();
    }

    private static void employeeTab() {
        // create text boxes
        JTextArea textLeft = new JTextArea(10, 16);
        JTextArea textRight = new JTextArea(10, 16);
        // left and right panels
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));
        // define texts
        textLeft.setText("Text Area left");
        textRight.setText("Text Area right");
        // add text boxes to panel
        panelLeft.add(textLeft);
        panelRight.add(textRight);
        // first split panel
        JSplitPane splitPane1 = new JSplitPane(SwingConstants.VERTICAL, panelLeft, panelRight);
        splitPane1.setDividerLocation(400);
        // set the orientation of the separator and location
        splitPane1.setOrientation(SwingConstants.VERTICAL);
        tab.add("  Employees  ", splitPane1);
    }

    private static void productsTab() {
        // create text boxes
        JTextArea textLeft = new JTextArea(10, 16);
        JTextArea textRight = new JTextArea(10, 16);
        // left and right panels
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));
        // define texts
        textLeft.setText("Text Area left");
        textRight.setText("Text Area right");
        // add text boxes to panel
        panelLeft.add(textLeft);
        panelRight.add(textRight);
        // first split panel
        JSplitPane splitPane2 = new JSplitPane(SwingConstants.VERTICAL, panelLeft, panelRight);
        splitPane2.setDividerLocation(400);
        // set the orientation of the separator and location
        splitPane2.setOrientation(SwingConstants.VERTICAL);
        //Main.mainPanel.add(tab);
        tab.add("  Products  ", splitPane2);
    }
}