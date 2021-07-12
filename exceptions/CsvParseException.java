import java.io.IOException;

public class CsvParseException extends IOException {
    public CsvParseException() {}
    public CsvParseException(String msg) {
        super(msg);
    }
}
