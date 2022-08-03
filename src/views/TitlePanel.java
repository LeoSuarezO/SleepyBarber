package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class TitlePanel extends JPanel {

    public TitlePanel() {
        JLabel label = new JLabel();
        Font font = new Font("Agency FB", Font.BOLD, 32);
        label.setText("Barber Shop");
        label.setFont(font);
        this.add(label);
    }
}
