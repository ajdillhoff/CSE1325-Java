package ClockExample;

import javax.swing.*;
import java.awt.*;

public class ClockExample {
    public static void main(String[] args) {
        var clockFrame = new Clock();

        var timer = new Timer(1000, clockFrame);
        timer.start();

        clockFrame.setTitle("ClockExample");
        clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clockFrame.setVisible(true);
    }
}