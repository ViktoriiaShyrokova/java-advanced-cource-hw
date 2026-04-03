package homeworks.lesson_11.task_2;

import homeworks.lesson_11.task_2.exception.CsvParseException;
import homeworks.lesson_11.task_2.exception.CsvReader;

import java.util.List;

public class CsvReaderMain {
    public static void main(String[] args) {
        System.out.println("=== Reading valid CSV ===");
        tryRead("./src/homeworks/lesson_11/task_2/test.csv");

        System.out.println();
        System.out.println("=== Reading invalid CSV ===");
        tryRead("./src/homeworks/lesson_11/task_2/test2.csv");

        System.out.println();
        System.out.println("=== Reading non-existent file ===");
        tryRead("no_such_file.csv");

    }

    public static void tryRead(String path) {
        try {
            List<String[]> rows = CsvReader.read(path);

            System.out.println("Read " + rows.size() + " data rows:");
            for (String[] row : rows) {
                System.out.println(" " + String.join(" | ", row));
            }
        } catch (CsvParseException e) {
            // Выводим всю информацию из исключения
            System.out.println("Parse failed!");
            System.out.println(" Line number: " + e.getLineNumber());
            System.out.println(" Raw content: '" + e.getRawLine() + "'");
            System.out.println(" Message: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println(" Caused by    : " + e.getCause().getClass().getSimpleName() + ": " +
                        e.getCause().getMessage());
            }
        }
    }
}
