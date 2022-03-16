
//Claude Butnaru
//This class creates buttons inherits from JButton
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class AButton extends JButton implements MouseListener {
    private static final Insets margins = new Insets(0, 0, 0, 0);
    private Color pressedColor = new Color(90, 90, 90);
    private Color rolloverColor = new Color(55, 55, 55);
    private Color normalColor = new Color(40, 40, 40);

    // constructor
    public AButton(Icon icon, String text) {
        super(icon);
        addMouseListener(this);
        Main.buttonToolBar.add(Box.createHorizontalStrut(10));
        setText(text);
        setMargin(margins);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVerticalTextPosition(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setBackground(normalColor);
        setForeground(Color.WHITE);
        setOpaque(true);
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Arial", Font.PLAIN, 10));
        setToolTipText(text);
    }

    // Adds employee data into DB
    private void addsNewEmployee() {
        if (getText().equals("Add Employee")) {
            ManagerUI.isDataReady = true;
            DB.insertEmployee(ManagerUI.employeeData().get(0), ManagerUI.employeeData().get(1),
                    ManagerUI.employeeData().get(2), ManagerUI.employeeData().get(3), ManagerUI.employeeData().get(4),
                    ManagerUI.employeeData().get(5), ManagerUI.employeeData().get(6), ManagerUI.employeeData().get(7),
                    ManagerUI.employeeData().get(8), ManagerUI.employeeData().get(9));
            ManagerUI.allEmployeesPanel.removeAll();
            ManagerUI.allEmployees();
            ManagerUI.positionTxt.setText("Data Inserted");
            ManagerUI.fNameTxt.setText("Data Inserted");
            ManagerUI.lNameTxt.setText("Data Inserted");
            ManagerUI.addressTxt.setText("Data Inserted");
            ManagerUI.cityTxt.setText("Data Inserted");
            ManagerUI.stateTxt.setText("Data Inserted");
            ManagerUI.zipTxt.setText("Data Inserted");
            ManagerUI.dobTxt.setText("Data Inserted");
            ManagerUI.sexTxt.setText("Data Inserted");
            ManagerUI.ssnTxt.setText("Data Inserted");
        }
    }

    // Adds a new product
    private void addsNewProduct() {
        if (getText().equals("Insert New Product")) {
            ManagerUI.isProductReady = true;
            DBP.insertProduct(ManagerUI.productData().get(0), ManagerUI.productData().get(1),
                    ManagerUI.productData().get(2), Double.parseDouble(ManagerUI.productData().get(3)),
                    Double.parseDouble(ManagerUI.productData().get(4)),
                    ManagerUI.productData().get(5));
            ManagerUI.txtCategory.setText("Data Inserted");
            ManagerUI.txtProdName.setText("Data Inserted");
            ManagerUI.txtProdBrand.setText("Data Inserted");
            ManagerUI.txtPriceBought.setText("Data Inserted");
            ManagerUI.txtPriceSold.setText("Data Inserted");
            ManagerUI.txtDescription.setText("Data Inserted");
            for (int i = 0; i < DBP.getProductCategories().size(); i++) {
                System.out.println(DBP.getProductCategories().get(i));
            }

        }
    }

    // Buttons on top select the respective tab
    private void selectedTab() {
        switch (getText()) {
            case "All Employees":
                ManagerUI.tab.setSelectedIndex(0);
                return;
            case "Add New Employee":
                ManagerUI.tab.setSelectedIndex(1);
                return;
            case "Edit Employee":
                ManagerUI.tab.setSelectedIndex(0);
                return;
            case "Remove Employee":
                ManagerUI.tab.setSelectedIndex(0);
                return;
            case "All Products":
                ManagerUI.tab.setSelectedIndex(2);
                return;
            case "Insert Product":
                ManagerUI.tab.setSelectedIndex(3);
                return;
            case "Edit Product":
                ManagerUI.tab.setSelectedIndex(2);
                return;
            case "Delete Product":
                ManagerUI.tab.setSelectedIndex(2);
                return;
        }
    }

    private void deletesEmployee() {
        if (getText().equals("Delete Employee")) {
            DB.deleteEmployee(String.valueOf(ManagerUI.presentLabelID));
            Component[] compArray = ManagerUI.allEmployeesPanel.getComponents();
            for (int i = 0; i < compArray.length; ++i) {
                if (compArray[i].getName().equals(String.valueOf(ManagerUI.presentLabelID))) {
                    ManagerUI.allEmployeesPanel.remove(i);
                }
            }
            // Clear textfields refresh everything
            ManagerUI.allEmployeesPanel.removeAll();
            ManagerUI.allEmployees();
            ManagerUI.employeePanel.removeAll();
            ManagerUI.employeeTextFields(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            Component[] compArray2 = ManagerUI.allEmployeesPanel.getComponents();
            JLabel[] labels = new JLabel[compArray2.length];
            for (int i = 0; i < compArray2.length; ++i) {
                if (compArray2[i] instanceof JLabel) {
                    labels[i] = (JLabel) compArray2[i];
                    labels[i].setHorizontalTextPosition(SwingConstants.RIGHT);
                    labels[i].setAlignmentX(SwingConstants.LEFT);
                }
            }
            ManagerUI.allEmployeesPanel.revalidate();
            ManagerUI.allEmployeesPanel.repaint();
            ManagerUI.scrollPaneL.getVerticalScrollBar().setValue(0);
        }
    }

    private void updatesEmployee() {
        if (getText().equals("Save Changes")) {

            ArrayList<Component> allComp = new ArrayList<Component>();
            ArrayList<TextField> tField = new ArrayList<TextField>();
            Collections.addAll(allComp, ManagerUI.employeePanel.getComponents());
            for (int i = 0; i < allComp.size(); ++i) {
                if (allComp.get(i) instanceof TextField) {
                    tField.add((TextField) (allComp.get(i)));
                }
            }
            DB.updateEmployee(Integer.parseInt(tField.get(0).getText()), tField.get(1).getText(),
                    tField.get(2).getText(), tField.get(3).getText(), tField.get(4).getText(),
                    tField.get(5).getText(), tField.get(6).getText(), tField.get(7).getText(),
                    tField.get(8).getText(), tField.get(9).getText(), tField.get(10).getText());
            tField.get(0).setText(String.valueOf(tField.get(0).getText()) + " Data changed successfully!");
        }
    }

    private void clearsFieldsEmployee() {
        if (getText().equals("Clear Fields")) {
            ManagerUI.positionTxt.setText("");
            ManagerUI.fNameTxt.setText("");
            ManagerUI.lNameTxt.setText("");
            ManagerUI.addressTxt.setText("");
            ManagerUI.cityTxt.setText("");
            ManagerUI.stateTxt.setText("");
            ManagerUI.zipTxt.setText("");
            ManagerUI.dobTxt.setText("");
            ManagerUI.sexTxt.setText("");
            ManagerUI.ssnTxt.setText("");
        }
    }

    private void clearsFieldsProduct() {
        if (getText().equals("Clear Product Fields")) {
            ManagerUI.txtCategory.setText("");
            ManagerUI.txtProdName.setText("");
            ManagerUI.txtProdBrand.setText("");
            ManagerUI.txtPriceBought.setText("");
            ManagerUI.txtPriceSold.setText("");
            ManagerUI.txtDescription.setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        addsNewEmployee();
        clearsFieldsEmployee();
        clearsFieldsProduct();
        deletesEmployee();
        updatesEmployee();
        addsNewProduct();
        selectedTab();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(pressedColor);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(rolloverColor);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(normalColor);

    }
}