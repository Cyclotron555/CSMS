
//Claude Butnaru
//ManagerWindow class. After login this window is displayed to the manager
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class ManagerUI {
    public static JTabbedPane tab = new JTabbedPane();
    public static JPanel employeePanel = new JPanel();
    public static JPanel allEmployeesPanel = new JPanel();
    public static int countLabels = 0;
    public static JLabel previouslyPressedLabel;
    public static boolean isDataReady;
    public static boolean isProductReady;
    public static ALabel autoEmployee;
    public static int presentEmployeID;
    private static JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
    private static JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
    public static JScrollPane scrollPaneL = new JScrollPane(panelLeft);
    public static int presentLabelID;
    public static ATextField positionTxt;
    public static ATextField fNameTxt;
    public static ATextField lNameTxt;
    public static ATextField addressTxt;
    public static ATextField cityTxt;
    public static ATextField stateTxt;
    public static ATextField zipTxt;
    public static ATextField dobTxt;
    public static ATextField sexTxt;
    public static ATextField ssnTxt;
    public static ATextField txtCategory;
    public static ATextField txtProdName;
    public static ATextField txtProdBrand;
    public static ATextField txtPriceBought;
    public static ATextField txtPriceSold;
    public static JTextArea txtDescription;

    public static void managerData() {

        Main.mainPanel.setLayout(new BorderLayout());
        employeeTab();
        insertNewEmployeeTab();
        productsTab();
        insertNewProductTab();
        Main.enableAllButtons();
    }

    private static void employeeTab() {
        JScrollPane scrollPaneL = new JScrollPane(panelLeft);
        scrollPaneL.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneL.getVerticalScrollBar().setUnitIncrement(16);
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));
        // add new panels for left and right panels
        panelLeft.add(allEmployeesPanel);
        panelRight.add(employeePanel);
        // Run the two methods that display employees from DB
        allEmployees();
        // Display 1st employee on opening
        employeeTextFields(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // first split panel
        JSplitPane splitPane1 = new JSplitPane(SwingConstants.VERTICAL, scrollPaneL, panelRight);
        // Separator distance from the left
        splitPane1.setDividerLocation(450);
        // set the orientation of the separator and location
        splitPane1.setOrientation(SwingConstants.VERTICAL);
        // Employees tab
        tab.add("  Employees | Details  ", splitPane1);

    }

    // Insert new employee TAB
    private static void insertNewEmployeeTab() {
        JPanel pT = new JPanel();
        JPanel pR = new JPanel();
        JPanel pB = new JPanel();
        JPanel pL = new JPanel();
        JPanel insertEmployeePanelOuter = new JPanel();
        JPanel insertEmployeePanelInner = new JPanel();
        insertEmployeePanelOuter.setLayout(new BorderLayout());
        final TitledBorder border = new TitledBorder("Add New Employee");
        border.setTitleFont(new Font("Arial", Font.PLAIN, 14));
        border.setTitleColor(new Color(200, 200, 200));
        insertEmployeePanelInner.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(40, 40, 40, 40), border));
        tab.add("  Insert New Employee  ", insertEmployeePanelOuter);
        pT.setPreferredSize(new Dimension(Main.Y / 6, 100));
        pR.setPreferredSize(new Dimension(Main.X / 6, 100));
        pB.setPreferredSize(new Dimension(Main.Y / 6, 100));
        pL.setPreferredSize(new Dimension(Main.X / 6, 100));
        pT.setBackground(new Color(33, 33, 33));
        pR.setBackground(new Color(33, 33, 33));
        pB.setBackground(new Color(33, 33, 33));
        pL.setBackground(new Color(33, 33, 33));
        insertEmployeePanelOuter.add(pT, BorderLayout.NORTH);
        insertEmployeePanelOuter.add(pR, BorderLayout.EAST);
        insertEmployeePanelOuter.add(pB, BorderLayout.SOUTH);
        insertEmployeePanelOuter.add(pL, BorderLayout.WEST);
        insertEmployeePanelOuter.add(insertEmployeePanelInner, BorderLayout.CENTER);

        // Displays all the labels and textfields from insert employee tab | ID is
        // automatically created
        ALabel positionLbl = new ALabel("  Position");
        positionTxt = new ATextField("Position");
        ALabel fNameLbl = new ALabel("  First Name");
        fNameTxt = new ATextField("First Name");
        ALabel lNameLbl = new ALabel("  Last Name");
        lNameTxt = new ATextField("Last Name");
        ALabel addressLbl = new ALabel("  Address");
        addressTxt = new ATextField("Address");
        ALabel cityLbl = new ALabel("  City");
        cityTxt = new ATextField("City");
        ALabel stateLbl = new ALabel("  State");
        stateTxt = new ATextField("State");
        ALabel zipLbl = new ALabel("  Zip");
        zipTxt = new ATextField("Zip");
        ALabel dobLbl = new ALabel("  Birth Date");
        dobTxt = new ATextField("Birth Date");
        ALabel sexLbl = new ALabel("  Sex");
        sexTxt = new ATextField("Gender");
        ALabel ssnLbl = new ALabel("  SSN Nr");
        ssnTxt = new ATextField("SSN");
        AButton btnInsertEmp = new AButton(new ImageIcon("./img/insertPeople.png"), "Add Employee");
        AButton btnClearFields = new AButton(new ImageIcon("./img/clearFields.png"), "Clear Fields");
        GridLayout grid = new GridLayout(11, 2);
        // grid.setBackground(new Color(33, 33, 33))
        insertEmployeePanelInner.setLayout(grid);
        insertEmployeePanelInner.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        insertEmployeePanelInner.setBackground(new Color(24, 24, 24));
        grid.setVgap(10);
        grid.setHgap(10);
        insertEmployeePanelInner.add(positionLbl);
        insertEmployeePanelInner.add(positionTxt);
        insertEmployeePanelInner.add(fNameLbl);
        insertEmployeePanelInner.add(fNameTxt);
        insertEmployeePanelInner.add(lNameLbl);
        insertEmployeePanelInner.add(lNameTxt);
        insertEmployeePanelInner.add(addressLbl);
        insertEmployeePanelInner.add(addressTxt);
        insertEmployeePanelInner.add(cityLbl);
        insertEmployeePanelInner.add(cityTxt);
        insertEmployeePanelInner.add(stateLbl);
        insertEmployeePanelInner.add(stateTxt);
        insertEmployeePanelInner.add(zipLbl);
        insertEmployeePanelInner.add(zipTxt);
        insertEmployeePanelInner.add(dobLbl);
        insertEmployeePanelInner.add(dobTxt);
        insertEmployeePanelInner.add(sexLbl);
        insertEmployeePanelInner.add(sexTxt);
        insertEmployeePanelInner.add(ssnLbl);
        insertEmployeePanelInner.add(ssnTxt);
        insertEmployeePanelInner.add(btnClearFields);
        insertEmployeePanelInner.add(btnInsertEmp);

    }

    // Products Tab
    private static void productsTab() {/*******************************************************
                                        *HERE * HERE * HERE * HERE * HERE * HERE * HERE * HERE*
                                        *******************************************************/
        GridBagLayout gridRight = new GridBagLayout();
        GridBagConstraints gbcRight = new GridBagConstraints();
        // left and right panels
        JPanel panelLeft = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        JPanel panelRight = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
        panelLeft.setBackground(new Color(33, 33, 33));
        panelRight.setBackground(new Color(33, 33, 33));

        // divider - first split panel | split the panel vertically
        JSplitPane splitPane2 = new JSplitPane(SwingConstants.VERTICAL, panelLeft, panelRight);
        // divider set initial location (it can be moved)
        splitPane2.setDividerLocation(400);
        // set the orientation of the divider
        splitPane2.setOrientation(SwingConstants.VERTICAL);
        // Products tab
        tab.add("  Products | Categories  ", splitPane2);








    }

    private static void insertNewProductTab() {
        GridBagLayout gridP = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel insertProductPanel = new JPanel();

        tab.add("  Insert New Product  ", insertProductPanel);
        insertProductPanel.setLayout(gridP);
        insertProductPanel.setBackground(new Color(33, 33, 33));

        // Labels
        ALabel lblCategory = new ALabel(" Category");
        ALabel lblProdName = new ALabel(" Product Name");
        ALabel lblProdBrand = new ALabel(" Brand");
        ALabel lblPriceBought = new ALabel(" Price Bought");
        ALabel lblPriceSold = new ALabel(" Price Sold");
        ALabel lblDescription = new ALabel(" Decription");

        // Textfields
        txtCategory = new ATextField("Category");
        txtProdName = new ATextField("Product Name");
        txtProdBrand = new ATextField("Brand");
        txtPriceBought = new ATextField("Price Bought");
        txtPriceSold = new ATextField("Price Sold");
        txtDescription = new JTextArea("Decription");
        JScrollPane scrollTExtArea = new JScrollPane(txtDescription, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Buttons
        AButton btnInsertProd = new AButton(new ImageIcon("./img/insertProduct.png"), "Insert New Product");
        AButton btnClearFields = new AButton(new ImageIcon("./img/clearFields.png"), "Clear Product Fields");

        // Insert Labels in grid
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 0;
        insertProductPanel.add(lblCategory, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 1;
        insertProductPanel.add(lblProdName, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 2;
        insertProductPanel.add(lblProdBrand, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 3;
        insertProductPanel.add(lblPriceBought, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 4;
        insertProductPanel.add(lblPriceSold, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 5;
        insertProductPanel.add(lblDescription, gbc);
        gbc.ipadx = 375;
        gbc.ipady = 50;
        gbc.gridx = 0;
        gbc.gridy = 6;
        insertProductPanel.add(btnClearFields, gbc);

        // Insert textfields in grid
        gbc.gridx = 1;
        gbc.gridy = 0;
        insertProductPanel.add(txtCategory, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        insertProductPanel.add(txtProdName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        insertProductPanel.add(txtProdBrand, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        insertProductPanel.add(txtPriceBought, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        insertProductPanel.add(txtPriceSold, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        insertProductPanel.add(scrollTExtArea, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        insertProductPanel.add(btnInsertProd, gbc);

    }

    // Displays all the employees on labels on the left side of the screen in
    // ManagerUI
    public static void allEmployees() {
        int employeeCount = DB.displayEmployee().size();
        GridLayout gridLeft = new GridLayout(employeeCount, 1);
        allEmployeesPanel.setLayout(gridLeft);
        allEmployeesPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        allEmployeesPanel.setBackground(new Color(33, 33, 33));
        gridLeft.setVgap(10);
        gridLeft.setHgap(25);
        // Iterates through the employees | the employees arraylist is continous for
        // all employees so every other 12th item in the list is another employee and
        // it starts with the ID every other i + 3 you get the next last name and so
        // on for a list of 1 employee there are 12 items like ID, firstName, lastName
        // etc.
        // then it continues with another employee
        if (employeeCount > 0) {
            for (int i = 0; i < employeeCount; ++i) {
                if (i % 12 == 0) {
                    autoEmployee = new ALabel(
                            "ID - " + DB.displayEmployee().get(i) + " | " + DB.displayEmployee().get(i + 3) + ", "
                                    + DB.displayEmployee().get(i + 2));
                    autoEmployee.setName(String.valueOf(i));
                    allEmployeesPanel.add(autoEmployee);
                }
            }
        }

    }

    public static void employeeTextFields(int _id, int _position, int _fName, int _lName, int _Address, int _city,
            int _state, int _zip, int _dob, int _sex, int _ssn) {
        ALabel IDLbl = new ALabel("  Employee ID");
        ATextField IDTxt = new ATextField(DB.displayEmployee().get(_id));
        IDTxt.setEditable(false);
        IDTxt.setBackground(new Color(44, 62, 80));
        IDTxt.setForeground(new Color(192, 57, 43));
        ALabel positionLbl = new ALabel("  Position");
        ATextField positionTxt = new ATextField(DB.displayEmployee().get(_position));
        ALabel fNameLbl = new ALabel("  First Name");
        ATextField fNameTxt = new ATextField(DB.displayEmployee().get(_fName));
        ALabel lNameLbl = new ALabel("  Last Name");
        ATextField lNameTxt = new ATextField(DB.displayEmployee().get(_lName));
        ALabel addressLbl = new ALabel("  Address");
        ATextField addressTxt = new ATextField(DB.displayEmployee().get(_Address));
        ALabel cityLbl = new ALabel("  City");
        ATextField cityTxt = new ATextField(DB.displayEmployee().get(_city));
        ALabel stateLbl = new ALabel("  State");
        ATextField stateTxt = new ATextField(DB.displayEmployee().get(_state));
        ALabel zipLbl = new ALabel("  Zip");
        ATextField zipTxt = new ATextField(DB.displayEmployee().get(_zip));
        ALabel dobLbl = new ALabel("  Birth Date");
        ATextField dobTxt = new ATextField(DB.displayEmployee().get(_dob));
        ALabel sexLbl = new ALabel("  Sex");
        ATextField sexTxt = new ATextField(DB.displayEmployee().get(_sex));
        ALabel ssnLbl = new ALabel("  SSN Nr");
        ATextField ssnTxt = new ATextField(DB.displayEmployee().get(_ssn));
        AButton deleteEmployeeBtn = new AButton(new ImageIcon("./img/deletePeople.png"), "Delete Employee");
        AButton saveChangesBtn = new AButton(new ImageIcon("./img/saveChanges.png"), "Save Changes");
        GridLayout grid = new GridLayout(12, 2);
        employeePanel.setLayout(grid);
        employeePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        employeePanel.setBackground(new Color(33, 33, 33));
        grid.setVgap(10);
        grid.setHgap(75);
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
        employeePanel.add(deleteEmployeeBtn);
        employeePanel.add(saveChangesBtn);
        presentLabelID = Integer.parseInt(DB.displayEmployee().get(_id));
    }

    public static ArrayList<String> employeeData() {
        ArrayList<String> returnEData = new ArrayList<String>();
        if (isDataReady) {
            returnEData.add(positionTxt.getText());
            returnEData.add(fNameTxt.getText());
            returnEData.add(lNameTxt.getText());
            returnEData.add(addressTxt.getText());
            returnEData.add(cityTxt.getText());
            returnEData.add(stateTxt.getText());
            returnEData.add(zipTxt.getText());
            returnEData.add(dobTxt.getText());
            returnEData.add(sexTxt.getText());
            returnEData.add(ssnTxt.getText());
            returnEData.add("Data Inserted");
            returnEData.add("Data Deleted");
        }
        return returnEData;
    }

    public static ArrayList<String> productData() {
        ArrayList<String> returnPData = new ArrayList<String>();
        if (isProductReady) {
            returnPData.add(txtCategory.getText());
            returnPData.add(txtProdName.getText());
            returnPData.add(txtProdBrand.getText());
            returnPData.add(txtPriceBought.getText());
            returnPData.add(txtPriceSold.getText());
            returnPData.add(txtDescription.getText());
            returnPData.add("Data Iserted");
            returnPData.add("Data Deleted");
        }
        return returnPData;
    }
}