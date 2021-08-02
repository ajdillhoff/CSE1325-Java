import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuController extends JFrame implements ActionListener, ItemListener {
    JLabel infoLabel;

    public MenuController() {
        // Configure layout
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Configure and add information label
        infoLabel = new JLabel("CSE 1325");
        add(infoLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create first menu
        JMenu file = new JMenu("File");
        JMenuItem startItem = new JMenuItem("Start Game");
        JMenuItem saveItem = new JMenuItem("Save Character");
        JMenuItem loadItem = new JMenuItem("Load Character");
        JMenuItem quitItem = new JMenuItem("Quit");

        // Add listeners
        startItem.addActionListener(this);
        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        quitItem.addActionListener(this);

        // Add to JMenu
        file.add(startItem);
        file.add(saveItem);
        file.add(loadItem);
        file.add(quitItem);

        // Add file menu to main menu bar
        menuBar.add(file);

        // Create options menu
        JMenu options = new JMenu("Options");
        JMenuItem option1Item = new JMenuItem("Option 1");
        JMenuItem option2Item = new JMenuItem("Option 2");
        JCheckBoxMenuItem advancedItem = new JCheckBoxMenuItem("Advanced");

        // Configure options menu action listener
        option1Item.addActionListener(this);
        option2Item.addActionListener(this);
        advancedItem.addItemListener(this);

        // Create sub menu
        JMenu subMenu = new JMenu("Sub Menu");
        JMenuItem subItem1 = new JMenuItem("Sub Option 1");
        JMenuItem subItem2 = new JMenuItem("Sub Option 2");
        subMenu.add(subItem1);
        subMenu.add(subItem2);

        // Configure submenu action listener
        subItem1.addActionListener(this);
        subItem2.addActionListener(this);

        // Configure options menu
        options.add(option1Item);
        options.add(option2Item);
        options.add(subMenu);
        options.add(advancedItem);
        menuBar.add(options);

        // Frame configuration
        setTitle("Menu Bar Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();

        if (command.equals("Quit")) {
            dispose();
        }

        String msg = "You selected " + actionEvent.getActionCommand();
        infoLabel.setText(msg);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        if (itemEvent.getItem().getClass().equals(JCheckBoxMenuItem.class)) {
            var item = (JCheckBoxMenuItem) itemEvent.getItem();
            System.out.printf("%s: %b\n", item.getText(), item.getState());
        }
    }
}
