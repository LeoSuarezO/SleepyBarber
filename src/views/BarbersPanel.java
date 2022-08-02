package views;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

public class BarbersPanel extends JPanel {

    public BarbersPanel() {
        this.setLayout(new GridLayout());
    }

    public void addBarber(int myNumber) {
        this.add(new JButton("Barber - " + myNumber));
        updateUI();
    }

    public void markBusy(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.ORANGE);
    }

    public void markAvaliable(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.GRAY);
    }

    public void sleep(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.lightGray);
    }
}
