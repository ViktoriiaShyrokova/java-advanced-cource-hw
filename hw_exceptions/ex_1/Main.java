package hw_exceptions.ex_1;

public class Main {

    public static void main(String[] args) {

        FormValidator validator = new FormValidator();
        validator.validateAll("John", "john@example.com", 85);
        validator.validateAll("", "john@example.com", 10);
        validator.validateAll("John", "johnexample.com", 10);
        validator.validateAll("John", "john@examplecom", 15);
        validator.validateAll("John", "john@example.com", 105);
    }
}
