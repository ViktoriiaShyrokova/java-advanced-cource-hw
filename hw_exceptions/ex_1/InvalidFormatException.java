package hw_exceptions.ex_1;

public class InvalidFormatException extends ValidationException {
    public InvalidFormatException(String fieldName, String reason) {
        super(fieldName, reason);
    }
}
