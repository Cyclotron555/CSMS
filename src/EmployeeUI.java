//Claude Butnaru
//EmployeeWindow class. After employee login. the employee is displayed this window
import javax.swing.*;
import java.awt.*;

public class EmployeeUI {
    public static JTabbedPane tab1 = new JTabbedPane();

    public static void employeeData() {

        Main.mainPanel.setLayout(new BorderLayout());
        dutiesTab();
    }

    private static void dutiesTab() {
        // Create text boxes
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
        Main.mainPanel.add(tab1);
        tab1.add("  Duties  ", splitPane1);
    }
}
