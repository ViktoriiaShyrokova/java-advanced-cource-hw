package hw4.task2;

public class LogFile extends TestArtifact{

    private int sizeKb;

    public LogFile(int id, String name, int sizeKb) {
        super(id, name);
        this.sizeKb = sizeKb;
    }

    @Override
    public String getSummary() {
        return "[Log: " + sizeKb + " KB]";
    }

    @Override
    public String toString() {
        return getSummary();
    }
}
