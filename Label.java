import javax.swing.*;
import java.awt.*;

public class Label extends JTextPane {
    public Label(String label){
        setPreferredSize(new Dimension(60, 20));
        setFont(new Font("SANS_SERIF", Font.PLAIN, 11));
        setForeground(Color.black);
        setEditable(false);
        setText(label);
        setOpaque(false);
    }
}