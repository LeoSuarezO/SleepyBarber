package views;

import javax.swing.JFrame;

public class Window extends JFrame {

    private MainPanel mainPanel;

    public Window() {
        this.mainPanel = new MainPanel();
        this.setTitle("Sleepy Barber");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.add(mainPanel);
    }

    public void createBarber(int myNumber) {
        mainPanel.createBarber(myNumber);
    }

    public void createClient(int myNumber) {
        mainPanel.createClient(myNumber);
    }

    public void checkDuringCut(int myNumber) {
        mainPanel.checkDuringCuting(myNumber);
    }

    public void markFullRoom(int myNumber) {
        mainPanel.markFullRoom(myNumber);
    }

    public void showBusyStatus(int myNumber) {
        mainPanel.showBusyStatus(myNumber);
    }

    public void showAvaliableStatus(int myNumber) {
        mainPanel.showAvaliableStatus(myNumber);
    }

    public void sleeping(int myNumber) {
        mainPanel.sleeping(myNumber);
    }

    public void updateWaiting(int waiting) {
        mainPanel.updateWaiting(waiting);
    }

    public void updateLosed(int losed) {
        mainPanel.updateLosed(losed);
    }
}
