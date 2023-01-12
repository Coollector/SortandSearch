import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button() {
        setPreferredSize(new Dimension(100, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("SANS_SERIF", Font.PLAIN, 11));
    }
}