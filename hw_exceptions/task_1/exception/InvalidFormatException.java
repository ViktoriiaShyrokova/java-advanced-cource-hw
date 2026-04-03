package homeworks.lesson_11.task_1.exception;

public class InvalidFormatException extends ValidationException {
    private final String expectedFormat;    // описание ожидаемого формата
    public InvalidFormatException(String fieldName, Object value, String expectedFormat) {
        super(fieldName, value, "invalid format, expected: " + expectedFormat);
        this.expectedFormat = expectedFormat;
    }

    public String getExpectedFormat() {
        return expectedFormat;
    }
}
