import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel implements DocumentListener {
    private JTextField nameTextField;
    private JButton submitButton;

    public EditPanel(ActionListener listener) {
        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel namePanel = new JLabel("Name:");
        nameTextField = new JTextField("");
        submitButton = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE;
        add(namePanel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        nameTextField.getDocument().addDocumentListener(this);
        nameTextField.setPreferredSize(new Dimension(200, 25));
        add(nameTextField, constraints);

        // Add new panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        submitButton.addActionListener(listener);
        submitButton.setActionCommand("EditPanel.Submit");
        submitButton.setEnabled(false);
        buttonPanel.add(submitButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        cancelButton.addActionListener(listener);
        cancelButton.setActionCommand("EditPanel.Cancel");
        buttonPanel.add(cancelButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        add(buttonPanel, constraints);
    }

    public void clearFields() {
        nameTextField.setText("");
    }

    public String getPlayerName() {
        return nameTextField.getText();
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        submitButton.setEnabled(nameTextField.getDocument().getLength() != 0);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        submitButton.setEnabled(nameTextField.getDocument().getLength() != 0);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {

    }
}
