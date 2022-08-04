package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class SetFrame extends JFrame {

    private JLabel title;
    private JTextField clients;
    private JTextField barbers;
    private JTextField chairs;
    private JButton start;
    private JLabel bar;

    public SetFrame(ActionListener l) {
        this.setTitle("Sleepy Barber");
        this.setBackground(Color.white);
        this.setSize(200, 300);
        this.setLayout(new GridLayout(6, 1, 2, 5));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        title = new JLabel("Sleepy Barber SetUp");
        clients = new JTextField();
        barbers = new JTextField();
        chairs = new JTextField();
        bar = new JLabel();
        bar .setIcon(new ImageIcon(getClass().getResource("/images/line.png")));
        start = new JButton("Start");
        start.setActionCommand(Commands.START.name());
        start.addActionListener(l);
        this.setAlwaysOnTop(true);
        init();
    }

    private void init() {
        Font font = new Font("Agency FB", Font.BOLD, 24);
        title.setBackground(Color.white);
        title.setBorder(BorderFactory.createEmptyBorder(5, 10, 2, 10));
        title.setFont(font);
        this.add(title);
        clients.setBorder(BorderFactory.createTitledBorder("Clients Quantity"));
        this.add(clients);
        barbers.setBorder(BorderFactory.createTitledBorder("Barbers Quantity"));
        this.add(barbers);
        chairs.setBorder(BorderFactory.createTitledBorder("Chairs Disponibility"));
        this.add(chairs);
        this.add(start);

        bar.setBackground(Color.white);
        this.add(bar);
    }

    public int getBarbers() {
        return Integer.parseInt(barbers.getText());
    }

    public int getCustomers() {
        return Integer.parseInt(clients.getText());
    }

    public int getChairs() {
        return Integer.parseInt(chairs.getText());
    }
}
