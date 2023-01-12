import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scene extends JPanel implements ActionListener {

    public Button[] buttons = new Button[6];
    public String[] buttonLabels = {"Generate", "Bubble Sort", "Insertion Sort", "Shell Sort", "LinearSearch", "Binary Search"};
    public View ausgabe = new View();
    public Array array = new Array(new Ausgabe(), new Ausgabe());
    public Suche suche = new Suche();
    public Ausgabe erfolg = new Ausgabe();

    public Suche amount = new Suche();

    public Scene() {
        setPreferredSize(Fenster.windowSize);
        setBackground(Color.white);

        for (int i = 0; i < 6; i++) {
            buttons[i] = new Button();
            buttons[i].setText(buttonLabels[i]);
            buttons[i].addActionListener(this);
        }

        add(buttons[0]);
        add(amount);
        add(ausgabe);
        add(buttons[1]);
        add(buttons[2]);
        add(buttons[3]);
        add(new Label("Loops: "));
        add(array.loopsAusgabe);
        add(new Label("Exec. Time:"));
        add(array.execTimeAusgabe);
        add(buttons[4]);
        add(buttons[5]);
        add(new Label("Suche: "));
        suche.addActionListener(this);
        add(suche);
        add(new Label("Erfolg: "));
        add(erfolg);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            array.generate((amount.getText().equals("")) ? 20000 : Integer.parseInt(amount.getText()));
            ausgabe.setText(array.toString());
        } else if (e.getSource() == buttons[1]) {
            array.bubbleSort();
            ausgabe.setText(array.toString());
        } else if (e.getSource() == buttons[2]) {
            array.insertionSort();
            ausgabe.setText(array.toString());
        } else if (e.getSource() == buttons[3]) {
            array.shellSort();
            ausgabe.setText(array.toString());
        } else if (e.getSource() == buttons[4]) {
            erfolg.setText(array.linearSearch(Integer.parseInt(suche.getText())));
        } else if (e.getSource() == buttons[5]) {
            erfolg.setText(array.binarySearch(Integer.parseInt(suche.getText())));
        }
    }
}