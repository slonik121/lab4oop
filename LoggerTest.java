import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    private final String logFilePath = "logs.txt";
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = Logger.getInstance();
        File file = new File(logFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(logFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSingletonInstance() {
        Logger anotherLogger = Logger.getInstance();
        assertSame(logger, anotherLogger, "Повинен бути повернутий той самий екземпляр Logger");
    }

    @Test
    void testLogMessage() throws IOException {
        String testMessage = "Тестове повідомлення для логування";
        logger.log(testMessage);

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line = reader.readLine();
            assertNotNull(line, "Файл логів не повинен бути порожнім");
            assertTrue(line.contains(testMessage), "Файл логів повинен містити тестове повідомлення");
        }
    }

    @Test
    void testLogFileTimestamp() throws IOException {
        String testMessage = "Перевірка часової мітки";
        logger.log(testMessage);

        try (BufferedReader reader = new BufferedReader(new FileReader(logFilePath))) {
            String line = reader.readLine();
            assertNotNull(line, "Файл логів не повинен бути порожнім");
            assertTrue(line.matches("\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\] \\[ЛОГ\\] .*"),
                    "Запис у логу повинен містити коректну часову мітку");
        }
    }
}
