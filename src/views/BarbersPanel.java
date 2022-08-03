package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class BarbersPanel extends JPanel {

    public BarbersPanel() {
        GridLayout layout = new GridLayout();
        layout.setHgap(1);
        layout.setVgap(2);
        this.setLayout(layout);
    }

    public void addBarber(int myNumber) {
        JButton button = new JButton("Barber - " + myNumber);
        Font font = new Font("Segoe", Font.BOLD, 14);
        button.setFont(font);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.add(String.valueOf(myNumber), button);
        updateUI();
    }

    public void markBusy(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.decode("#4F4789"));
    }

    public void markAvaliable(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.decode("#0A630E"));
    }

    public void sleep(int myNumber) {
        this.getComponent(myNumber).setBackground(Color.decode("#E2E2E2"));
    }
}
