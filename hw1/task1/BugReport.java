package hw1.task1;

public class BugReport {

    int id;
    String title;
    String severity; // `"LOW"` / `"MEDIUM"` / `"HIGH"` / `"CRITICAL"`),
    boolean isOpen;
    String assignedTo;

    public BugReport(int id, String title, String severity, boolean isOpen, String assignedTo) {
        this.id = id;
        this.title = title;
        this.severity = severity;
        this.isOpen = isOpen;
        this.assignedTo = assignedTo;
    }

    public BugReport(int id, String title, String severity, boolean isOpen) {
        this(id,title,severity,isOpen, "Unassigned");
    }

    public BugReport(String title, String severity) {
        this(0,title,severity, true);
    }

    public  BugReport( BugReport other) {
        this(other.id, other.title, other.severity, other.isOpen, other.assignedTo);
    }

}
