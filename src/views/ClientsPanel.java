package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ClientsPanel extends JPanel {

    private JLabel title;
    private JPanel clients;
    private JScrollPane scroll;

    public ClientsPanel() {
        clients = new JPanel();
        Font font = new Font("Segoe", Font.BOLD, 14);
        clients.setLayout(new BoxLayout(clients, BoxLayout.Y_AXIS));
        title = new JLabel("Clients");
        title.setFont(font);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        scroll = new JScrollPane();   
        scroll.setBorder(BorderFactory.createEmptyBorder(2,10,2,5));
        init();
    }

    private void init() {
        this.add(title);
        scroll.setViewportView(clients);
        this.add(scroll);
    }

    public void addClient(int myNumber) {
        JButton button = new JButton("Client - " + myNumber);
        button.setBackground(Color.decode("#605F5E"));
        button.setForeground(Color.white);
        Font font = new Font("Segoe", Font.PLAIN, 14);
        button.setFont(font);
        clients.add(button);
        updateUI();
    }

    public void check(int myNumber) {
        clients.getComponent(myNumber).setBackground(Color.decode("#0A630E"));
        updateUI();
        
    }

    public void lose(int myNumber) {
        clients.getComponent(myNumber).setBackground(Color.decode("#C71212"));
        updateUI();
    }
}
