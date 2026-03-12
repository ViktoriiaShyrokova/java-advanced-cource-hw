package hw5.task2;

public interface Exportable {

    String exportToCsv();
    default String getFormat() {
        return "CSV";
    }
}
