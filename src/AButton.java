
//Claude Butnaru
//This class creates buttons inherits from JButton
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AButton extends JButton {
    private static final Insets margins = new Insets(0, 0, 0, 0);
    private Color pressedColor = new Color(90, 90, 90);
    private Color rolloverColor = new Color(55, 55, 55);
    private Color normalColor = new Color(40, 40, 40);
    

    // constructor
    public AButton(Icon icon, String text) {
        super(icon);
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

        // onChange listener for button changing colors on mouse over, pressed
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (getModel().isPressed()) {
                    setBackground(pressedColor);
                    addsNewEmployee();
                    clearsFields();
                    deletesEmployee();
                    selectedTab();
                } else if (getModel().isRollover()) {
                    setBackground(rolloverColor);
                } else {
                    setBackground(normalColor);
                }
            }
        });
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

    // Buttons on top select the respective tab
    private void selectedTab() {
        if (getText().equals("All Employees")) {
            ManagerUI.tab.setSelectedIndex(0);
            return;
        }
        if (getText().equals("Add New Employee")) {
            ManagerUI.tab.setSelectedIndex(1);
            return;
        }
        if (getText().equals("Edit Employee")) {
            ManagerUI.tab.setSelectedIndex(0);
            return;
        }
        if (getText().equals("Remove Employee")) {
            ManagerUI.tab.setSelectedIndex(0);
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
                    labels[i] = (JLabel)compArray2[i];
                    labels[i].setHorizontalTextPosition(SwingConstants.RIGHT);
                    labels[i].setAlignmentX(SwingConstants.LEFT);
                    labels[i].setIcon(new ImageIcon("./img/arrowRight.png"));
                }
            }
            ManagerUI.allEmployeesPanel.revalidate();
            ManagerUI.allEmployeesPanel.repaint();
            ManagerUI.scrollPaneL.getVerticalScrollBar().setValue(0);
        }
    }

    private void clearsFields() {
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
}