package hw5.task2;

public interface Printable {

    void print();

    default String getHeader() {
        return "=== Report ===";
    }
}