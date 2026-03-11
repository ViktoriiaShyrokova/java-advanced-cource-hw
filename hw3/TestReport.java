package hw3;

import java.util.Objects;

public class TestReport {

    private final int id;
    private String suitName;
    private String status;
    private static int totalCount;
    private static int passCount;
    private static int failCount;
    private static int skipCount;

    public TestReport(String suitName) {
        this.id = ++totalCount;
        this.suitName = suitName;
    }

    public void markPass() {
        this.status = "PASS";
        passCount++;
    }

    public void markFail() {
        this.status = "FAIL";
        failCount++;
    }

    public void markSkip() {
        this.status = "SKIP";
        skipCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TestReport that = (TestReport) o;
        return id == that.id && Objects.equals(suitName, that.suitName) && Objects.equals(status, that.status);
    }


    public static String getSummary() {
        return String.format("Total: %d | Pass: %d | Fail: %d | Skip: %d | Rate: %.1f %%", totalCount, passCount, failCount, skipCount, (double) passCount / totalCount * 100);
    }
    public static void reset() {
        totalCount = passCount = failCount = skipCount = 0;
    }
}
