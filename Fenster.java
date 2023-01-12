import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame {

    static public Dimension windowSize = new Dimension(650, 600);

    public Fenster() {

        setSize(windowSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);
        setResizable(false);
        setTitle("Sortieren & Suchen");

        add(new Scene());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Fenster();
    }
}