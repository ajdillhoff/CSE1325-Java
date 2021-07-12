public class CsvParseTest {
    public static String[] parseCsvLine(String line) throws CsvParseException {
        String[] rawElements = line.trim().split(",");
        if (rawElements.length == 1) {
            throw new CsvParseException("Not a valid line of CSV.");
        }

        return rawElements;
    }

    public static void main(String[] args) {
        String test = "no commas here!";

        try {
            var elements = parseCsvLine(test);
        } catch (CsvParseException e) {
            e.printStackTrace();
        }
    }
}
