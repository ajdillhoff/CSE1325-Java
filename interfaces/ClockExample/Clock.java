package ClockExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class Clock extends JFrame implements ActionListener {
    private DisplayComponent display;
    public Clock() {
        display = new DisplayComponent();
        add(display);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String msg = Instant.ofEpochMilli(actionEvent.getWhen()).toString();
        display.setMsg(msg);
    }
}

class DisplayComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private String msg = "Unknown";

    public void setMsg(String msg) {
        this.msg = msg;
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.drawString(msg, MESSAGE_X, MESSAGE_Y);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
