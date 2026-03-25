package hw_exceptions.ex_1;

public class OutOfRangeException extends ValidationException {
    public OutOfRangeException(String fieldName, String reason) {
        super(fieldName, reason);
    }
}
