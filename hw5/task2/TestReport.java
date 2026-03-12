package hw5.task2;

public class TestReport implements Printable,Exportable,Archivable{

    private String title;
    private int passCount;
    private int failCount;
    private boolean isArchived;

    public TestReport(String title, int passCount, int failCount) {
        this.title = title;
        this.passCount = passCount;
        this.failCount = failCount;
    }

    @Override
    public void archive() {
        System.out.println(title + " is archived");
        this.isArchived = true;
    }

    @Override
    public boolean isArchived() {
        return isArchived;
    }

    @Override
    public String exportToCsv() {
        return String.format("title,passCount,failCount\n%s,%d,%d",
                title, passCount, failCount);
    }

    @Override
    public void print() {
        System.out.println("Title: " + title + " - passed: " + passCount + ", failed: " + failCount);
    }
}
