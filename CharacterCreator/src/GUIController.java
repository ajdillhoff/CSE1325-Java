import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private EditPanel editPanel;

    public GUIController() {
        // Configure frame
        mainFrame = new JFrame("Character Creator");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(640, 480);

        editPanel = new EditPanel(new EditPlayerListener());

        configureMenu();
        configureMainPanel();

        mainFrame.setVisible(true);
    }

    private void configureMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New Character");
        JMenuItem saveItem = new JMenuItem("Save Character");
        JMenuItem loadItem = new JMenuItem("Load Character");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Set up listeners
        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        mainFrame.add(menuBar, BorderLayout.NORTH);
    }

    private void configureMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton newButton = new JButton("New Character");
        JButton loadButton = new JButton("Load Character");
        newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        newButton.addActionListener(this);
        loadButton.addActionListener(this);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(newButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(loadButton);
        mainPanel.add(Box.createVerticalGlue());

        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    private void showEditPanel() {
        if (editPanel.isShowing()) {
            return;
        }

        mainFrame.remove(mainPanel);
        mainFrame.add(editPanel);
        mainFrame.revalidate();  // recalculates the layout
        mainFrame.repaint();
    }

    private void showMainPanel() {
        if (mainPanel.isShowing()) {
            return;
        }

        mainFrame.remove(editPanel);
        mainFrame.add(mainPanel);
        mainFrame.revalidate();  // recalculates the layout
        mainFrame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionName = actionEvent.getActionCommand();
        switch (actionName) {
            case "New Character":
                showEditPanel();
                break;
            case "Save Character":
                break;
            case "Load Character":
                break;
            case "Exit":
                mainFrame.dispose();
        }
    }

    private class EditPlayerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String actionName = actionEvent.getActionCommand();
            switch (actionName) {
                case "EditPanel.Submit":
                    Player p = new Player(editPanel.getPlayerName());
                    System.out.printf("Player %s created.\n", p);
                    editPanel.clearFields();
                    showMainPanel();
                    break;
                case "EditPanel.Cancel":
                    editPanel.clearFields();
                    showMainPanel();
                    break;
            }
        }
    }
}
