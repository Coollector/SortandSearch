import javax.swing.*;
import java.awt.*;

public class Ausgabe extends JTextPane {
    public Ausgabe(){
        setPreferredSize(new Dimension(80, 20));
        setFont(new Font("SANS_SERIF", Font.BOLD, 11));
        setForeground(Color.black);
        setEditable(false);
        setOpaque(true);
    }
}