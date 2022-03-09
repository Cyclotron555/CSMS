
//Claude Butnaru
//This class creates Textfields inherits from TextField
import java.awt.*;
import java.awt.event.*;

public class ATextField extends TextField implements MouseListener {
    private Color textColor = new Color(40, 40, 40);

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
                        || getText().equals("Gender") || getText().equals("SSN")) {
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

    }

    // Mouse Exit
    @Override
    public void mouseExited(MouseEvent e) {

    }

}