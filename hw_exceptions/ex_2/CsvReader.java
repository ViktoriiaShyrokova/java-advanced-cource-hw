package hw_exceptions.ex_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

    public static List<String[]> read(String filePath) throws CsvParseException {
        List<String[]> csv = new ArrayList<>();
        String line;
        int lineNumber = 1;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            System.out.println("file found");
            reader.skip(1);
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                System.out.println("Reading lineNumber: " + lineNumber);
                String[] parts = line.split(",");
                if (parts.length < 2) throw new CsvParseException(lineNumber, Arrays.toString(parts));
                csv.add(parts);
                System.out.println("Line successfully added to list, lines in list: " + csv.size());
            }

        } catch (IOException e) {
            throw new CsvParseException("Error! File not found: ", e);
        }

        return csv;
    }
}
