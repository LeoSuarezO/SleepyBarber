package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

    public TitlePanel() {
        JLabel label = new JLabel();

        label.setText("Sleepy Barber");
        this.add(label);
    }
}
