
//Claude Butnaru
//This class creates the buttons in the toolbar menu under the main menu bar
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ToolBarButton extends JButton {
    private static final Insets margins = new Insets(0, 0, 0, 0);
    private Color pressedColor = new Color(90, 90, 90);
    private Color rolloverColor = new Color(55, 55, 55);
    private Color normalColor = new Color(40, 40, 40);

    // constructor
    public ToolBarButton(Icon icon, String text) {
        super(icon);
        Main.buttonToolBar.add(Box.createHorizontalStrut(10));
        setText(text);
        setMargin(margins);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVerticalTextPosition(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setBorder(null);
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
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isPressed()) {
                    setBackground(pressedColor);
                } else if (getModel().isRollover()) {
                    setBackground(rolloverColor);
                } else {
                    setBackground(normalColor);
                }
            }
        });
    }
}