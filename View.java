import javax.swing.*;
import java.awt.*;

public class View extends JScrollPane {
    private final JTextArea label;

    public View(){
        setPreferredSize(new Dimension(550, 500));
        setFont(new Font("SANS_SERIF", Font.BOLD, 11));
        setForeground(Color.black);
        setOpaque(false);
        this.label = new JTextArea();
        this.label.setEditable(false);
        add(this.label);
        setViewportView(this.label);
    }

    public void setText(String text){
        this.label.setText(text);
    }
}