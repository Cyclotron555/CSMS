
//Claude Butnaru
//This class creates Textfields inherits from TextField
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class ATextField extends TextField implements MouseListener {
    private Color textColor = new Color(40, 40, 40);
    private TextField idTExtField;
    private int txtFieldID;

    // constructor
    public ATextField(String text) {
        super();
        addMouseListener(this);
        setText(text);
        setColumns(25);
        setBackground(textColor);
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Verdana", Font.PLAIN, 30));
        // Clears fields on focus
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("Position") || getText().equals("First Name") || getText().equals("Last Name")
                        || getText().equals("Address")
                        || getText().equals("City") || getText().equals("State") || getText().equals("Zip")
                        || getText().equals("Birth Date")
                        || getText().equals("Gender") || getText().equals("SSN") || getText().equals("Category")
                        || getText().equals("Product Name") || getText().equals("Brand")
                        || getText().equals("Price Bought")
                        || getText().equals("Price Sold")) {
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }

    // Mouse Clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        if (getText().equals("Position") || getText().equals("First Name") || getText().equals("Last Name")
                || getText().equals("Address")
                || getText().equals("City") || getText().equals("State") || getText().equals("Zip")
                || getText().equals("Birth Date")
                || getText().equals("Gender") || getText().equals("SSN")) {
            setText("");
        }
    }

    // Mouse Pressed
    @Override
    public void mousePressed(MouseEvent e) {

    }

    // Mouse Released
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // Mouse Enter
    @Override
    public void mouseEntered(MouseEvent e) {
        // Sets text in ID textfield cannot be changed
        if (getBackground().equals(new Color(44, 62, 80)) && getParent() == ManagerUI.employeePanel) {
            ArrayList<Component> allComponents = new ArrayList<Component>();
            ArrayList<TextField> txtField = new ArrayList<TextField>();
            Collections.addAll(allComponents, ManagerUI.employeePanel.getComponents());
            for (int i = 0; i < allComponents.size(); ++i) {
                if (allComponents.get(i) instanceof TextField) {
                    txtField.add((TextField) (allComponents.get(i)));
                }
            }
            txtFieldID = Integer.parseInt(txtField.get(0).getText());
            idTExtField = txtField.get(0);

            idTExtField.setText(String.valueOf(txtFieldID) + " -ID cannot be changed-");
        }

    }

    // Mouse Exit
    @Override
    public void mouseExited(MouseEvent e) {
        if (getBackground().equals(new Color(44, 62, 80)) && getParent() == ManagerUI.employeePanel) {
            idTExtField.setText(String.valueOf(txtFieldID));
        }

    }

}