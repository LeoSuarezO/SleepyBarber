package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    private JPanel mainPanel;

    public Window() {
        this.setTitle("arg0");
        this.mainPanel = new MainPanel();
        this.setSize(600, 400);
        this.add(mainPanel);
    }
}
