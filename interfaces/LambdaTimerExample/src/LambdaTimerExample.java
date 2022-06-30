import javax.swing.*;
import java.util.Date;

public class LambdaTimerExample {
    public static void main(String[] args) {
        var timer = new Timer(1000, actionEvent -> {
            System.out.println("The time is " + new Date());
        });

        timer.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}
