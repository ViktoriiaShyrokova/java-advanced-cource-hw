package hw_date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRunLog {

    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String testName;

    public TestRunLog(LocalDateTime startedAt, LocalDateTime finishedAt, String testName) {
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.testName = testName;
    }

    public TestRunLog(LocalDateTime startedAt, String testName) {
        this.startedAt = startedAt;
        this.testName = testName;
    }

    public Duration getDuration() {
        return Duration.between(startedAt,finishedAt);
    }
    public boolean isSlowTest(int thresholdSeconds) {
        return getDuration().toSeconds() > thresholdSeconds;
    }
    public String toLogLine(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s - %dms",startedAt.format(dtf),testName,getDuration().toMillis());
    }

    public static TestRunLog start(String testName) {
        return new TestRunLog(LocalDateTime.now(),testName);
    }
    public TestRunLog finish() {
        return new TestRunLog(startedAt,LocalDateTime.now(),testName);
    }

    @Override
    public String toString() {
        return "TestRunLog{" +
                "startedAt=" + startedAt +
                ", finishedAt=" + finishedAt +
                ", testName='" + testName + '\'' +
                '}';
    }
}
