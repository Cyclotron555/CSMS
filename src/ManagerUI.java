
//Claude Butnaru
//ManagerWindow class. After login this window is displayed to the manager
import javax.swing.*;
import java.awt.*;

public class ManagerUI {
    public static JTabbedPane tab = new JTabbedPane();
    private static JPanel employeePanel = new JPanel();
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
        panelRight.add(employeePanel);
        insertEmployee();
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
        //JTextArea textRight = new JTextArea(10, 16);
        // left and right panels
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.LEFT));
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));
        // define texts
        //textLeft.setText("Text Area left");
        //textRight.setText("Text Area right");
        // add text boxes to panel
        panelLeft.add(textLeft);
        
        // first split panel
        JSplitPane splitPane2 = new JSplitPane(SwingConstants.VERTICAL, panelLeft, panelRight);
        splitPane2.setDividerLocation(400);
        // set the orientation of the separator and location
        splitPane2.setOrientation(SwingConstants.VERTICAL);
        //Main.mainPanel.add(tab);
        tab.add("  Products  ", splitPane2);
    }

    private static void insertEmployee() {
        
        EmployeeLabel positionLbl = new EmployeeLabel("Position");
        EmployeeLabel fNameLbl = new EmployeeLabel("First Name");
        EmployeeLabel lNameLbl = new EmployeeLabel("Last Name");
        EmployeeLabel addressLbl = new EmployeeLabel("Address");
        EmployeeLabel cityLbl = new EmployeeLabel("City");
        EmployeeLabel stateLbl = new EmployeeLabel("State");
        EmployeeLabel zipLbl = new EmployeeLabel("Zip");
        EmployeeLabel dobLbl = new EmployeeLabel("Birth Date");
        EmployeeLabel sexLbl = new EmployeeLabel("Sex");
        EmployeeLabel ssnLbl = new EmployeeLabel("SSN Nr");
        GridLayout grid = new GridLayout(10,1);
        employeePanel.setLayout(grid);
        employeePanel.setBackground(new Color(33, 33, 33));
        grid.setVgap(25);
        employeePanel.add(positionLbl);
        employeePanel.add(fNameLbl);
        employeePanel.add(lNameLbl);
        employeePanel.add(addressLbl);
        employeePanel.add(cityLbl);
        employeePanel.add(stateLbl);
        employeePanel.add(zipLbl);
        employeePanel.add(dobLbl);
        employeePanel.add(sexLbl);
        employeePanel.add(ssnLbl);
        
    }
}