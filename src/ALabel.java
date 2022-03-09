
//Claude Butnaru
//This class creates labels inherits from JLabel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ALabel extends JLabel implements MouseListener {
    private Color rolloverColor1 = new Color(52, 73, 94);
    private Color rolloverColor2 = new Color(231, 76, 60);
    private Color normalColor1 = new Color(44, 62, 80);
    private Color normalColor2 = new Color(192, 57, 43);
    public static int lastClickedLabel;

    // constructor
    public ALabel(String text) {
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
        setFont(new Font("Verdana", Font.PLAIN, 30));
        setToolTipText(text.toUpperCase());
        setLabelColors();
    }

    // Mouse Clicked
    @Override
    public void mouseClicked(MouseEvent e) {
        if (getParent() == ManagerUI.allEmployeesPanel) {
            ManagerUI.employeePanel.removeAll();
            lastClickedLabel = Integer.parseInt(ManagerUI.previouslyPressedLabel.getName());
            ManagerUI.employeeTextFields(lastClickedLabel, lastClickedLabel + 1, lastClickedLabel + 2,
                    lastClickedLabel + 3, lastClickedLabel + 4, lastClickedLabel + 5,
                    lastClickedLabel + 6, lastClickedLabel + 7, lastClickedLabel + 8, lastClickedLabel + 9,
                    lastClickedLabel + 10);
        }
    }

    // Mouse Pressed | Sets an icon on the pressed label
    // How this works:  If the label is located in the
    // panel on the left, and if the previous pressed label isn't null ( because
    // first time will be null), I set the icon to null, so the previous label is
    // reset then I set the icon to the present label 
    // By pressing the label it becomes the last label pressed. 
    // The variable is previouslyPressedLabel
    @Override
    public void mousePressed(MouseEvent e) {
        if (ManagerUI.previouslyPressedLabel != null && getParent() == ManagerUI.allEmployeesPanel) {
            ManagerUI.previouslyPressedLabel.setHorizontalTextPosition(SwingConstants.LEFT);
            ManagerUI.previouslyPressedLabel.setAlignmentX(SwingConstants.LEFT);
            ManagerUI.previouslyPressedLabel.setIcon(null);
            ManagerUI.previouslyPressedLabel.revalidate();
        }
        if (getParent() == ManagerUI.allEmployeesPanel) {
            setHorizontalTextPosition(SwingConstants.RIGHT);
            setAlignmentX(SwingConstants.LEFT);
            setIcon(new ImageIcon("./img/arrowRight.png"));
            ManagerUI.previouslyPressedLabel = (JLabel) e.getSource();
        }
    }

    // Mouse Released
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // Mouse Enter | Sets labels color on mouse enter(a lighter shade)) - for all labels
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