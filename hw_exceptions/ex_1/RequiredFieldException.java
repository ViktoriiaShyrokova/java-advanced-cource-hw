package hw_exceptions.ex_1;

public class RequiredFieldException extends ValidationException {
    public RequiredFieldException(String fieldName) {
        super(fieldName, "Field is required");
    }
}
