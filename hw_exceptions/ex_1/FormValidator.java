package hw_exceptions.ex_1;

import java.util.ArrayList;
import java.util.List;

public class FormValidator {
    public void validateRequired(String fieldName, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new RequiredFieldException(fieldName);
        }
    }
    public void validateEmail(String email) {
        if(!email.contains("@") || !email.contains(".")){
            throw new InvalidFormatException("email", "Invalid email format");
        }
    }
    public void validateScore(int score, int min, int max) {
        if(score < min || score > max) {
            throw new OutOfRangeException("score", "Score is out of range");
        }
    }
    public void validateAll(String name, String email, int score) {
        List<ValidationException> errors = new ArrayList<>();
        try {
            validateRequired("name", name);
            validateEmail(email);
            validateScore(score, 0, 100);
        } catch (ValidationException e) {
            errors.add(e);
            System.out.println(errors);
        }
    }
}
