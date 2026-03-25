package hw_exceptions.ex_1;

public class ValidationException extends RuntimeException {
    String fieldName;
    String reason;

    public ValidationException(String fieldName, String reason) {
        super("Field '" + fieldName + "': " + reason);
        this.fieldName = fieldName;
    }
}
