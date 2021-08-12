import javax.swing.*;

public class CharacterCreator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUIController();
        });
    }
}
