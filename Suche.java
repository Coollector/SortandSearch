import javax.swing.*;
import java.awt.*;

public class Suche extends JTextField {
    public Suche(){
        setPreferredSize(new Dimension(40, 20));
        setFont(new Font("SANS_SERIF", Font.BOLD, 11));
        setForeground(Color.black);
        setEditable(true);
        setOpaque(false);
    }
}