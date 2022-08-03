package views;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class StatisticsPanel extends JPanel {

    private JLabel waiting;
    private JLabel losed;
    private JPanel stats;
    private JLabel time;
    private JLabel attended;
    private JPanel attendPanel;

    public StatisticsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 10, 5, 10));
        waiting = new JLabel("Waiting: 0");
        losed = new JLabel("Losed: 0");
        time = new JLabel("Time: 0");
        attended = new JLabel("Attended: 0");
        stats = new JPanel();
        init();
    }

    private void init() {
        Font font = new Font("Segoe", Font.BOLD, 14);
        waiting.setFont(font);
        losed.setFont(font);
        time.setFont(font);
        attended.setFont(font);
        stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
        stats.setBorder(BorderFactory.createTitledBorder("Statistics"));
        attendPanel = new JPanel();
        attendPanel.setLayout(new BoxLayout(attendPanel, BoxLayout.Y_AXIS));
        attendPanel.setBorder(BorderFactory.createTitledBorder("Attending"));
        stats.add(time);
        stats.add(waiting);
        stats.add(losed);
        stats.add(attended);
        
        this.add(stats);

        this.add(attendPanel);
    }

    public void updateWaiting(int waiting) {
        this.waiting.setText("Waiting: " + waiting);
        updateUI();
    }

    public void updateLosed(int losed) {
        this.losed.setText("Losed: " + losed);
        updateUI();
    }

    public void attend(int myNumber) {
        JButton button = new JButton("Client - " + myNumber);
        button.setBackground(Color.decode("#0A2463"));
        button.setForeground(Color.white);
        Font font = new Font("Segoe", Font.PLAIN, 14);
        button.setFont(font);
        attendPanel.add(button);
        updateUI();
    }

    public void cutFinish(int attended) {
        attendPanel.remove(0);
        this.attended.setText("Attended: " + attended);
        updateUI();
    }

    public void updateTime(int time) {
        this.time.setText("Time: " + time);
        updateUI();
    }
}
