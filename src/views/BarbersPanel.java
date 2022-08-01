package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class BarbersPanel extends JPanel {

    public BarbersPanel() {
        this.setLayout(new GridLayout());
    }

    public void addBarber(int myNumber) {
        this.add(new JButton("Barber - " + myNumber));
        updateUI();
    }
}
