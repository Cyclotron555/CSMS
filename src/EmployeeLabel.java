
//Claude Butnaru
//This class creates labels for employees and employees info
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeLabel extends JLabel implements MouseListener {
    private Color rolloverColor1 = new Color(52, 73, 94);
    private Color rolloverColor2 = new Color(231, 76, 60);
    private Color normalColor1 = new Color(44, 62, 80);
    private Color normalColor2 = new Color(192, 57, 43);

    // constructor
    public EmployeeLabel(String text) {
        super();
        addMouseListener(this);
        setText(text);
        ManagerUI.countLabels++;
        setVerticalTextPosition(CENTER);
        setHorizontalTextPosition(CENTER);
        setBorder(null);
        setForeground(Color.WHITE);
        setOpaque(true);
        setForeground(new Color(200, 200, 200));
        setFont(new Font("Verdana", Font.PLAIN, 32));
        setToolTipText(text.toUpperCase());
        setLabelColors();
    }

    // Mouse Clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        if (getText().equals("  First Name")) {
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

    // Mouse Enter | Sets labels color on mouse enter(a lighter shade))
    @Override
    public void mouseEntered(MouseEvent e) {
        if (getBackground() == normalColor1) {
            setBackground(rolloverColor1);
        } else if (getBackground() == normalColor2) {
            setBackground(rolloverColor2);
        }
    }

    // Mouse Exit | Sets labels color on mouse exit back to normal
    @Override
    public void mouseExited(MouseEvent e) {
        if (getBackground() == rolloverColor1) {
            setBackground(normalColor1);
        } else if (getBackground() == rolloverColor2) {
            setBackground(normalColor2);
        }
    }

    // Sets the labels base colors
    private void setLabelColors() {
        if (ManagerUI.countLabels % 2 == 0) {
            setBackground(normalColor1);
        } else {
            setBackground(normalColor2);
        }
    }
}