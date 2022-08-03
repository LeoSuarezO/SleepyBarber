package views;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

public class MainPanel extends JPanel {

    private TitlePanel title;
    private ClientsPanel clients;
    private BarberShopPanel shop;
    private ConvPanel convPanel;
    private StatisticsPanel statistics;

    public MainPanel() {
        title = new TitlePanel();
        clients = new ClientsPanel();
        shop = new BarberShopPanel();
        convPanel = new ConvPanel();
        statistics = new StatisticsPanel();
        this.setLayout(new BorderLayout());
        init();
    }

    private void init() {
        this.add(title, BorderLayout.NORTH);
        this.add(shop, BorderLayout.CENTER);
        this.add(clients, BorderLayout.WEST);
        this.add(statistics, BorderLayout.EAST);
        this.add(convPanel, BorderLayout.SOUTH);
    }

    public void createBarber(int myNumber) {
        shop.createBarber(myNumber);
    }

    public void createClient(int myNumber) {
        clients.addClient(myNumber);
    }

    public void checkDuringCuting(int myNumber) {
        clients.check(myNumber);
        statistics.attend(myNumber);
    }

    public void markFullRoom(int myNumber) {
        clients.lose(myNumber);
    }

    public void showBusyStatus(int myNumber) {
        shop.showBusyStatus(myNumber);
    }

    public void showAvaliableStatus(int myNumber, int attended) {
        shop.showAvaliableStatus(myNumber);
        statistics.cutFinish(attended);
    }

    public void sleeping(int myNumber) {
        shop.sleeping(myNumber);
    }

    public void updateWaiting(int waiting) {
        statistics.updateWaiting(waiting);
    }

    public void updateLosed(int losed) {
        statistics.updateLosed(losed);
    }

    public void updateTime(int time) {
        statistics.updateTime(time);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(new ImageIcon(getClass().getResource("/images/background.jpg")).getImage(), 0, 0, getWidth(),
                getHeight(),
                this);

        setOpaque(false);
        super.paint(g);
    }
}
