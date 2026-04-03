# Задание 2 — CSV-парсер с try-with-resources

**Компоненты для создания:**
- `CsvParseException` — checked исключение с `lineNumber` и `rawLine`
- `CsvReader` — класс с методом `read(String filePath)`
- `test_data.csv` — тестовый файл

---

## ТК-2.1 — CsvParseException хранит номер строки и исходные данные

| | |
|---|---|
| **ID** | TC-11-2-01 |
| **Приоритет** | HIGH |
| **Компонент** | `CsvParseException` |

**Предусловие:**  
Создан класс `CsvParseException extends Exception` с полями `lineNumber` (int) и `rawLine` (String).

**Шаги:**
1. Создать: `new CsvParseException(4, "INVALID_LINE", "expected 2 columns")`
2. Вызвать `getLineNumber()`
3. Вызвать `getRawLine()`
4. Вызвать `getMessage()`

**Ожидаемый результат:**
- `getLineNumber()` возвращает `4`
- `getRawLine()` возвращает `"INVALID_LINE"`
- `getMessage()` содержит `"4"`, `"INVALID_LINE"` и `"expected 2 columns"`

---

## ТК-2.2 — CsvReader успешно читает корректный файл

| | |
|---|---|
| **ID** | TC-11-2-02 |
| **Приоритет** | HIGH |
| **Компонент** | `CsvReader.read()` |

**Предусловие:**  
Создан файл `valid.csv`:
```
name,email,score
Alice,alice@example.com,95
Bob,bob@example.com,78
Diana,diana@example.com,88
```

**Шаги:**
1. Вызвать `CsvReader.read("valid.csv")`
2. Проверить размер возвращённого списка
3. Проверить содержимое первой строки (`parts[0]`, `parts[1]`, `parts[2]`)

**Ожидаемый результат:**
- Метод завершается без исключений
- Список содержит **3** элемента (заголовок пропущен)
- `result.get(0)[0]` = `"Alice"`, `result.get(0)[1]` = `"alice@example.com"`

---

## ТК-2.3 — CsvReader бросает CsvParseException при невалидной строке

| | |
|---|---|
| **ID** | TC-11-2-03 |
| **Приоритет** | CRITICAL |
| **Компонент** | `CsvReader.read()` |

**Предусловие:**  
Создан файл `invalid.csv`:
```
name,email,score
Alice,alice@example.com,95
Bob,bob@example.com,78
INVALID_LINE_NO_COMMA
Diana,diana@example.com,88
```

**Шаги:**
1. Вызвать `CsvReader.read("invalid.csv")` в блоке `try/catch (CsvParseException e)`
2. Проверить `e.getLineNumber()`
3. Проверить `e.getRawLine()`
4. Проверить `e.getCause()`

**Ожидаемый результат:**
- Бросается `CsvParseException`
- `getLineNumber()` = `4` (строка 4 в файле, включая заголовок)
- `getRawLine()` = `"INVALID_LINE_NO_COMMA"`
- `getCause()` = `null` (это ошибка формата, не IO)

---

## ТК-2.4 — CsvReader оборачивает IOException в CsvParseException

| | |
|---|---|
| **ID** | TC-11-2-04 |
| **Приоритет** | HIGH |
| **Компонент** | `CsvReader.read()` |

**Предусловие:**  
Файл `nonexistent.csv` **не существует**.

**Шаги:**
1. Вызвать `CsvReader.read("nonexistent.csv")` в блоке `try/catch (CsvParseException e)`
2. Проверить тип `e.getCause()`
3. Проверить `e.getMessage()`

**Ожидаемый результат:**
- Бросается `CsvParseException` (не `IOException` напрямую!)
- `e.getCause()` является экземпляром `IOException` или `NoSuchFileException`
- `e.getMessage()` содержит слово `"IO"` или `"error"`

---

## ТК-2.5 — BufferedReader закрывается автоматически через try-with-resources

| | |
|---|---|
| **ID** | TC-11-2-05 |
| **Приоритет** | MEDIUM |
| **Компонент** | `CsvReader.read()` — управление ресурсами |

**Предусловие:**  
Реализован `CsvReader.read()` с использованием `try-with-resources`.

**Шаги:**
1. Вызвать `CsvReader.read("valid.csv")` — успешное чтение
2. Вызвать `CsvReader.read("invalid.csv")` — файл с ошибкой в строке
3. Вызвать `CsvReader.read("nonexistent.csv")` — файл отсутствует
4. После каждого вызова убедиться что программа продолжает работу (файл не заблокирован)

**Ожидаемый результат:**
- Во всех трёх случаях `BufferedReader` закрывается автоматически
- Файловый дескриптор освобождается даже при исключении
- Повторный вызов `read()` на том же файле выполняется без ошибок