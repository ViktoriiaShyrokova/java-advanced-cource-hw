package homeworks.lesson_11.task_1.exception;

public class RequiredFieldException extends ValidationException {
    public RequiredFieldException(String fieldName) {
        super(fieldName, null, "is required but was empty or null");
    }
}
