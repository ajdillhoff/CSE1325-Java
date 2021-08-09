import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class JFileChooserDemo extends JFrame implements DocumentListener, ActionListener {
    final private String programName = "JFileChooser Demo";
    private String documentName = "Unnamed.txt";
    private String fileName = "";
    private boolean isSaved = true;
    private boolean hasFile = false;

    JTextArea textArea;

    public JFileChooserDemo() {
        setTitle(getWindowTitle());
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        configureMenu();

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(this);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.add(textArea);

        add(textArea, BorderLayout.CENTER);

        setVisible(true);
    }

    private void configureMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        add(menuBar, BorderLayout.NORTH);
    }

    private String getWindowTitle() {
        return programName + " - " + documentName + (isSaved ? "" : "*");
    }

    private void newFile() {
        // Save file if necessary
        saveFile();

        try {
            textArea.getDocument().remove(0, textArea.getDocument().getLength());
            fileName = "";
            documentName = "Unnamed.txt";
            isSaved = true;
            hasFile = false;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() {
        if (isSaved) {
            return;
        }

        if (!hasFile) {
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                fileName = fileChooser.getSelectedFile().getPath();
                Path p = Path.of(fileName);
                documentName = p.getFileName().toString();

                // Write the data to the file
                writeData();
                hasFile = true;
            }
        } else {
            // Write the data to the file
            writeData();
        }
    }

    private void openFile() {
        saveFile();

        // Clear the text area if necessary
        try {
            textArea.getDocument().remove(0, textArea.getDocument().getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileName = fileChooser.getSelectedFile().getPath();
            Path p = Path.of(fileName);
            documentName = p.getFileName().toString();

            // Load the data
            loadData();
            hasFile = true;
            isSaved = true;
            setTitle(getWindowTitle());
        }
    }

    private void loadData() {
        try {
            File f = new File(fileName);
            byte[] rawData = Files.readAllBytes(f.toPath());
            String s = "";
            for (byte b : rawData) {
                s += Character.toString((char) b);
            }
            textArea.append(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeData() {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(textArea.getDocument().getText(0, textArea.getDocument().getLength()));
        } catch (FileNotFoundException | BadLocationException e) {
            e.printStackTrace();
        }

        isSaved = true;
        setTitle(getWindowTitle());
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        isSaved = false;
        setTitle(getWindowTitle());
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        isSaved = false;
        setTitle(getWindowTitle());
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "New":
                // Create a new file
                newFile();
                break;
            case "Open":
                // Open a file
                openFile();
                break;
            case "Save":
                // Save the file
                saveFile();
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JFileChooserDemo();
        });
    }
}
