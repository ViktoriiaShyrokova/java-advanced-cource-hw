package homeworks.lesson_11.task_1.exception;

public class ValidationException extends RuntimeException {
    private final String fieldName;
    private final Object rejectedValue;

    public ValidationException(String fieldName, Object rejectedValue, String reason) {
        // getMessage() вернет эту строку - то есть мы делаем ее понятней
        super("Field '" + fieldName + "': " + reason + " (rejected value: )" + rejectedValue + ")");
        this.fieldName = fieldName;
        this.rejectedValue = rejectedValue;
    }

    public String getFieldName() {
        return fieldName;
    }
    public Object getRejectedValue() {
        return rejectedValue;
    }
}
