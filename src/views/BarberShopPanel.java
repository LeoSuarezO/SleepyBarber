package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BarberShopPanel extends JPanel {

    private BarbersPanel barbers;
    private WaitPanel wait;

    public BarberShopPanel() {
        barbers = new BarbersPanel();
        wait = new WaitPanel();
        this.setBackground(Color.BLUE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        init();
    }
    
    private void init() {
        this.add(barbers);
    }
    
    public void createBarber(int myNumber) {
        barbers.addBarber(myNumber);
        repaint();
    }

    public void showBusyStatus(int myNumber) {
        barbers.markBusy(myNumber);
    }

    public void showAvaliableStatus(int myNumber) {
        barbers.markAvaliable(myNumber);
    }

    public void sleeping(int myNumber) {
        barbers.sleep(myNumber);
    }
}
