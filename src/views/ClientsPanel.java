package views;

import java.awt.Color;

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
        clients.setLayout(new BoxLayout(clients, BoxLayout.Y_AXIS));
        title = new JLabel("Clients");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        scroll = new JScrollPane();   
        init();
    }

    private void init() {
        this.add(title);
        scroll.setViewportView(clients);
        this.add(scroll);
    }

    public void addClient(int myNumber) {
        JButton button = new JButton("Client - " + myNumber);
        button.setBackground(Color.BLUE);
        clients.add(button);
        updateUI();
    }

    public void check(int myNumber) {
        clients.getComponent(myNumber).setBackground(Color.GREEN);
        updateUI();
        
    }

    public void lose(int myNumber) {
        clients.getComponent(myNumber).setBackground(Color.RED);
        updateUI();
    }
}
