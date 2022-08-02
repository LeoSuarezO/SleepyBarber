package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;

public class TitlePanel extends JPanel {

    public TitlePanel() {
        this.setLayout(new FlowLayout());
        JLabel icon = new JLabel();
        JLabel label = new JLabel();
        Font font = new Font("Agency FB", Font.BOLD, 32);
        label.setText("Barber Shop");
        label.setFont(font);
        this.add(icon);
        this.add(label);
    }
}
