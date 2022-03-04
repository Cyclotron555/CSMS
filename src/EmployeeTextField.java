
//Claude Butnaru
//This class creates labels for employees and employees info
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeTextField extends TextField implements MouseListener {
    private Color textColor = new Color(40, 40, 40);

    // constructor
    public EmployeeTextField(String text) {
        super();
        addMouseListener(this);
        setText(text);
        setColumns(25);
        setBackground(textColor);
        setForeground(Color.WHITE);
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Verdana", Font.PLAIN, 32));
    }

    // Mouse Clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        if (getText().equals("First Name")) {
            JOptionPane.showMessageDialog(Main.mainPanel,
                    "Hello.");
        }

    }

    // Mouse Pressed
    @Override
    public void mousePressed(MouseEvent e) {

    }

    // Mouse Released
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

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