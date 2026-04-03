package homeworks.lesson_11.task_2.exception;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<String[]> read(String filePath) throws CsvParseException {
        List<String[]>  result  = new ArrayList<>();
        int             lineNum = 0;

        try(
                BufferedReader reader = Files.newBufferedReader(Paths.get(filePath),
                        StandardCharsets.UTF_8)
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineNum++;

                // Пропускаем 1-ю строку
                if (lineNum == 1) continue;

                // Пропускаем пустую строку
                if (line.isBlank()) continue;

                String[] parts = line.split(",");

                if (parts.length < 2)
                    throw new CsvParseException(lineNum, line, "expected at least 2 columns, got: " + parts.length);

                result.add(parts);

            }

        } catch (Exception e) {
            throw new CsvParseException(lineNum, "", "IO error: " + e.getMessage(), e);
        }

        return result;
    }
}
