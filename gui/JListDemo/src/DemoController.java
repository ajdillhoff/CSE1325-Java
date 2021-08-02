import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DemoController implements ActionListener {
    private JFrame mainFrame;
    private JList cartList;
    private JList<String> inventoryList;
    private String[] items;
    private ArrayList<String> cart;
    private int selectedItem = -1;

    public DemoController() {
        // Configure frame
        mainFrame = new JFrame("JList Demo");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(500, 230);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        cart = new ArrayList<>();
        items = new String[] {
                "Apple",
                "Banana",
                "Orange",
                "Grapes",
                "Cherries",
                "Tomato",
                "Watermelon"
        };

        inventoryList = new JList<>(items);
        inventoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventoryList.addListSelectionListener(listSelectionEvent -> {
            if (listSelectionEvent.getValueIsAdjusting()) {
                selectedItem = inventoryList.getSelectedIndex();
            }
        });
        JScrollPane scrollPane = new JScrollPane(inventoryList);
        scrollPane.setPreferredSize(new Dimension(200, 180));
        mainFrame.add(scrollPane);

        // Add a button for adding an item
        JButton button = new JButton("->");
        button.addActionListener(this);
        mainFrame.add(button);

        // Add the cart
        cartList = new JList(cart.toArray());
        JScrollPane cartScrollPane = new JScrollPane(cartList);
        cartScrollPane.setPreferredSize(new Dimension(200, 180));
        mainFrame.add(cartScrollPane);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (selectedItem == -1) {
            return;
        }

        String item = items[selectedItem];
        cart.add(item);
        cartList.setListData(cart.toArray());
    }
}
