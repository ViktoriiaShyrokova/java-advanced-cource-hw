package hw_exceptions.ex_2;

public class Main {

    public static void main(String[] args) {

        try {
            CsvReader.read("src\\test.csv");
        } catch (CsvParseException e) {
            System.out.println(e.getCause());
        }
    }
}
