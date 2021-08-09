import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

class FileOpThread implements Runnable {
    private ActionListener listener;
    private String textData;
    private String fileName;

    public FileOpThread(ActionListener listener, String fileName, String textData) {
        this.listener = listener;
        this.fileName = fileName;
        this.textData = textData;
    }

    @Override
    public void run() {
        long then = System.nanoTime();
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(textData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.printf("Save took %d ms.\n", TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then));
        listener.actionPerformed(new ActionEvent(this, 0, "File Saved"));
    }
}

public class FileOpUtilities {
    public static int writeData(ActionListener listener, String fileName, String textData) {
        Thread t = new Thread(new FileOpThread(listener, fileName, textData));
        t.start();

        return 0;
    }
}
