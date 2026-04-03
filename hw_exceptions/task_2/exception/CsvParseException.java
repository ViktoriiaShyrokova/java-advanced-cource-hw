package homeworks.lesson_11.task_2.exception;

public class CsvParseException extends Exception {
    private final int       lineNumber;
    private final String    rawLine;

    // Конструктор без причины - для ошибок валидации формата
    public CsvParseException(int lineNumber, String rawLine, String reason) {
        super("CSV parse error at line " + lineNumber + ": " + reason + " raw: '" + rawLine + "'");
        this.lineNumber = lineNumber;
        this.rawLine = rawLine;
    }

    // Конструктор - для оборачивания IOException и других
    public CsvParseException(int lineNumber, String rawLine, String reason, Throwable cause) {
        super("CSV parse error at line " + lineNumber + ": " + reason + " raw: '" + rawLine + "'", cause);
        this.lineNumber = lineNumber;
        this.rawLine = rawLine;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getRawLine() {
        return rawLine;
    }
}
