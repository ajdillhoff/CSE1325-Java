import javax.swing.*;
import java.awt.*;

public class CardLayoutExample extends JFrame {
    public CardLayoutExample() {
        // This frame contains buttons which will switch between cards
        setLayout(new FlowLayout());

        JButton b1 = new JButton("Card 1");
        JButton b2 = new JButton("Card 2");
        JButton b3 = new JButton("Card 3");
        JButton b4 = new JButton("Card 4");

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        // Create the deck
        JPanel deckPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        deckPanel.setLayout(cardLayout);

        // Create card 1
        JPanel cardPanel1 = new JPanel();
        JLabel cardLabel1 = new JLabel("Card 1 Selected");
        cardPanel1.add(cardLabel1);

        // Create card 2
        JPanel cardPanel2 = new JPanel();
        JLabel cardLabel2 = new JLabel("Card 2 Selected");
        cardPanel2.add(cardLabel2);

        // Create card 3
        JPanel cardPanel3 = new JPanel();
        JLabel cardLabel3 = new JLabel("Card 3 Selected");
        cardPanel3.add(cardLabel3);

        // Create card 1
        JPanel cardPanel4 = new JPanel();
        JLabel cardLabel4 = new JLabel("Card 4 Selected");
        cardPanel4.add(cardLabel4);

        // Add the cards to the deck
        deckPanel.add(cardPanel1, "Panel1");
        deckPanel.add(cardPanel2, "Panel2");
        deckPanel.add(cardPanel3, "Panel3");
        deckPanel.add(cardPanel4, "Panel4");

        b1.addActionListener((ae) -> cardLayout.show(deckPanel, "Panel1"));
        b2.addActionListener((ae) -> cardLayout.show(deckPanel, "Panel2"));
        b3.addActionListener((ae) -> cardLayout.show(deckPanel, "Panel3"));
        b4.addActionListener((ae) -> cardLayout.show(deckPanel, "Panel4"));

        // Add the deck to the main frame
        add(deckPanel);

        // Configure frame options
        setSize(400, 300);
        setTitle("Card Layout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CardLayoutExample();
        });
    }
}
