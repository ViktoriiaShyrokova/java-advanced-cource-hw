package homeworks.lesson_11.task_1.validator;

import homeworks.lesson_11.task_1.exception.InvalidFormatException;
import homeworks.lesson_11.task_1.exception.OutOfRangeException;
import homeworks.lesson_11.task_1.exception.RequiredFieldException;
import homeworks.lesson_11.task_1.exception.ValidationException;

import java.util.ArrayList;
import java.util.List;

public class FormValidator {
    // Проверить, что поле не пустое
    public static void validateRequired(String fieldName, String value) {
        if (value == null || value.isBlank())
            throw new RequiredFieldException(fieldName);
    }

    // Проверить формат email: должен содержать '@' и '.' после '@'
    public static void validateEmail(String email) {
        // Сначала проверяем, что не пустой
        validateRequired("email", email);

        // Затем - формат
        if (!email.contains("@") || !email.contains("."))
            throw new InvalidFormatException("email", email, "user@domain.com");

        // Дополнительно: точка должна быть ПОСЛЕ '@'
        int atIndex     = email.indexOf("@");
        int dotFirstIndex = email.indexOf(".");
        int dotIndex    = email.lastIndexOf("."); //john.doe@gmail.com

        if (dotIndex <= atIndex || dotFirstIndex == 0 || atIndex == 0)
            throw new InvalidFormatException("email", email, "user@domain.com");
    }

    // Проверить, что score в допустимом диапазоне [min, max]
    public static void validateScore(int score, int min, int max) {
        if (score <= min || score >= max)
            throw new OutOfRangeException("score", score, min, max);
    }

    public static List<ValidationException> validateAll(String name, String email, int score, int min, int max) {
        List<ValidationException> errors = new ArrayList<>();

        try {
            validateRequired("name", name);
        } catch (ValidationException e) {
            errors.add(e);
        }

        try {
            validateEmail(email);
        } catch (ValidationException e) {
            errors.add(e);
        }

        try {
            validateScore(score, min, max);
        } catch (ValidationException e) {
            errors.add(e);
        }

        return errors;  // Все ОК - пустой список
    }
}
