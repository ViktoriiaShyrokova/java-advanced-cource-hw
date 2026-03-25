package hw_exceptions.ex_2;

public class CsvParseException extends Exception {
    private int lineNumber;
    private String rawLine;

    public CsvParseException(int lineNumber, String rawLine) {
        super("Error: Line format is invalid: line" + lineNumber + ": " + rawLine);
    }

    public CsvParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
