package hw5.task1;

public class PrioritizedTest implements Prioritizable {

    private int id;
    private String name;
    private int priority;

    public PrioritizedTest(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getPriorityLabel() {
        switch (priority) {
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
