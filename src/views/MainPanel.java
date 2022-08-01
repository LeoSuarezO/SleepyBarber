package views;

import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;

public class MainPanel extends JPanel {

    private TitlePanel title;
    private ClientsPanel clients;
    private BarberShopPanel shop;
    private FinishedPanel finish;
    private WaitPanel wait;
    private LosePanel lose;

    public MainPanel() {
        title = new TitlePanel();
        clients = new ClientsPanel();
        shop = new BarberShopPanel();
        finish = new FinishedPanel();
        lose = new LosePanel();
        this.setLayout(new BorderLayout());
        init();
    }

    private void init() {
        this.add(title, BorderLayout.NORTH);
        this.add(shop, BorderLayout.CENTER);
        this.add(clients, BorderLayout.WEST);
        this.add(lose, BorderLayout.EAST);
        this.add(finish, BorderLayout.SOUTH);
    }

    public void createBarber(int myNumber) {
        shop.createBarber(myNumber);
    }

    public void createClient(int myNumber) {
        clients.addClient(myNumber);
    }

    public void checkDuringCuting(int myNumber) {
        clients.check(myNumber);
    }

    public void markFullRoom(int myNumber) {
        clients.lose(myNumber);
    }
}
