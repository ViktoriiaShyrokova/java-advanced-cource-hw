package hw1.task1;

import hw1.task2.Config;

public class Main {

    public static void main(String[] args) {

        BugReport bug1 = new BugReport(1, "Link is broken", "LOW", true, "Jack");
        BugReport bug2 = new BugReport(2, "Logo is not shown", "HIGH", true);
        BugReport bug3 = new BugReport("Login button is disabled", "HIGH");

        BugReport bugCopy = new BugReport(bug1);
        bugCopy.severity = "MEDIUM";

        System.out.println(bug1.title + " - " + bug1.severity);
        System.out.println(bugCopy.title + " - " + bugCopy.severity);

    }
}
