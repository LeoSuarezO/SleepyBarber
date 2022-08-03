package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class ConvPanel extends JPanel {
    public ConvPanel() {
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(getClass().getResource("/images/background.png")).getImage(), 0, 0, getWidth(),
                getHeight(),
                this);

        setOpaque(false);
        super.paint(g);
    }
}
