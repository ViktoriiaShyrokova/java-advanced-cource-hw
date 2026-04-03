package homeworks.lesson_11.task_1;

import homeworks.lesson_11.task_1.exception.ValidationException;
import homeworks.lesson_11.task_1.validator.FormValidator;

import java.util.List;

public class FormValidatorMain {
    public static void main(String[] args) {

        System.out.println("=== Test 1: all invalid ===");
        List<ValidationException> errors = FormValidator.validateAll(
                "",
                "non-email",
                -5,
                0,
                100
        );

        if (errors.isEmpty()) {
            System.out.println("All valid!");
        } else {
            System.out.println("Found " + errors.size() + " error(s):");
            for (ValidationException e: errors) {
                System.out.println(" [" + e.getClass().getSimpleName() + "] " + e.getMessage());
            }
        }

        System.out.println();
        System.out.println("=== Test 2: all valid ===");
        List<ValidationException> ok = FormValidator.validateAll(
                "Alice",
                "alice@example.org",
                85,
                0,
                100
        );
        System.out.println(ok.isEmpty() ? "All valid!" : "Errors: " + ok.size());

        System.out.println();
        System.out.println("=== Test 3: only email invalid ===");
        List<ValidationException> partial = FormValidator.validateAll(
                "Alice",
                "@alice@example.org",
                72,
                0,
                100
        );
        partial.forEach(e -> System.out.println("  " + e.getMessage()));
    }
}
