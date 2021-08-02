import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventDemo extends JFrame implements ActionListener {
    class MyButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.out.printf("We can respond using an inner class that implements ActionListener!\n");
        }
    }

    public ButtonEventDemo() {
        JButton button = new JButton("PRESS ME");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.printf("We can respond using an ActionListener object!\n");
            }
        });

        button.addActionListener(new MyButtonHandler());
        button.addActionListener(this);
        add(button);

        // Frame configuration
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.printf("We can have our main class respond to the events!\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ButtonEventDemo();
        });
    }
}
