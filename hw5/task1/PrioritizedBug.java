package hw5.task1;

public class PrioritizedBug implements Prioritizable {

    private int id;
    private String description;
    private int severity;

    public PrioritizedBug(int id, String description, int severity) {
        this.id = id;
        this.description = description;
        this.severity = severity;
    }

    @Override
    public int getPriority() {
        return severity;
    }

    @Override
    public String getPriorityLabel() {
        switch (severity) {
            case 1:
                return "CRITICAL";
            case 2:
                return "HIGH";
            case 3:
                return "MEDIUM";
            default:
                return "LOW";
        }
    }
}
