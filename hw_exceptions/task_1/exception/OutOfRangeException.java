package homeworks.lesson_11.task_1.exception;

public class OutOfRangeException extends ValidationException {
    private final int min;
    private final int max;

    public OutOfRangeException(String fieldName, int value, int min, int max) {
        super(fieldName, value, "must be between " + min + " and " + max + ", got: " + value);
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
}
