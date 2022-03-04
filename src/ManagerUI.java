
//Claude Butnaru
//ManagerWindow class. After login this window is displayed to the manager
import javax.swing.*;
import java.awt.*;

public class ManagerUI {
    public static JTabbedPane tab = new JTabbedPane();
    private static JPanel employeePanel = new JPanel();
    public static int countLabels = 0;

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
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
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
        //Employees tab
        tab.add("  Employees  ", splitPane1);
    }

    private static void productsTab() {
        // create text boxes
        JTextArea textLeft = new JTextArea(10, 16);
        // left and right panels
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));

        // add text boxes to panel
        panelLeft.add(textLeft);

        // divider - first split panel | split the panel vertically
        JSplitPane splitPane2 = new JSplitPane(SwingConstants.VERTICAL, panelLeft, panelRight);
        //divider set initial location (it can be moved)
        splitPane2.setDividerLocation(400);
        // set the orientation of the divider
        splitPane2.setOrientation(SwingConstants.VERTICAL);
        // Products tab
        tab.add("  Products  ", splitPane2);
    }

    private static void insertEmployee() {

        EmployeeLabel IDLbl = new EmployeeLabel("  Employee ID");
        EmployeeTextField IDTxt = new EmployeeTextField(DB.displayEmployee().get(0));
        EmployeeLabel positionLbl = new EmployeeLabel("  Position");
        EmployeeTextField positionTxt = new EmployeeTextField(DB.displayEmployee().get(1));
        EmployeeLabel fNameLbl = new EmployeeLabel("  First Name");
        EmployeeTextField fNameTxt = new EmployeeTextField(DB.displayEmployee().get(2));
        EmployeeLabel lNameLbl = new EmployeeLabel("  Last Name");
        EmployeeTextField lNameTxt = new EmployeeTextField(DB.displayEmployee().get(3));
        EmployeeLabel addressLbl = new EmployeeLabel("  Address");
        EmployeeTextField addressTxt = new EmployeeTextField(DB.displayEmployee().get(4));
        EmployeeLabel cityLbl = new EmployeeLabel("  City");
        EmployeeTextField cityTxt = new EmployeeTextField(DB.displayEmployee().get(5));
        EmployeeLabel stateLbl = new EmployeeLabel("  State");
        EmployeeTextField stateTxt = new EmployeeTextField(DB.displayEmployee().get(6));
        EmployeeLabel zipLbl = new EmployeeLabel("  Zip");
        EmployeeTextField zipTxt = new EmployeeTextField(DB.displayEmployee().get(7));
        EmployeeLabel dobLbl = new EmployeeLabel("  Birth Date");
        EmployeeTextField dobTxt = new EmployeeTextField(DB.displayEmployee().get(8));
        EmployeeLabel sexLbl = new EmployeeLabel("  Sex");
        EmployeeTextField sexTxt = new EmployeeTextField(DB.displayEmployee().get(9));
        EmployeeLabel ssnLbl = new EmployeeLabel("  SSN Nr");
        EmployeeTextField ssnTxt = new EmployeeTextField(DB.displayEmployee().get(10));
        GridLayout grid = new GridLayout(11, 2);
        employeePanel.setLayout(grid);
        employeePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        employeePanel.setBackground(new Color(33, 33, 33));
        grid.setVgap(25);
        grid.setHgap(100);
        employeePanel.add(IDLbl);
        employeePanel.add(IDTxt);
        employeePanel.add(positionLbl);
        employeePanel.add(positionTxt);
        employeePanel.add(fNameLbl);
        employeePanel.add(fNameTxt);
        employeePanel.add(lNameLbl);
        employeePanel.add(lNameTxt);
        employeePanel.add(addressLbl);
        employeePanel.add(addressTxt);
        employeePanel.add(cityLbl);
        employeePanel.add(cityTxt);
        employeePanel.add(stateLbl);
        employeePanel.add(stateTxt);
        employeePanel.add(zipLbl);
        employeePanel.add(zipTxt);
        employeePanel.add(dobLbl);
        employeePanel.add(dobTxt);
        employeePanel.add(sexLbl);
        employeePanel.add(sexTxt);
        employeePanel.add(ssnLbl);
        employeePanel.add(ssnTxt);
    }

    
}