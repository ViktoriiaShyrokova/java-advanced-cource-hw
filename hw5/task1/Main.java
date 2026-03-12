package hw5.task1;

public class Main {

    public static void main(String[] args) {

        PrioritizedTest test1 = new PrioritizedTest(1,"User login with valid data",1);
        PrioritizedTest test2 = new PrioritizedTest(2,"User can read Agreement conditions",3);

        PrioritizedBug bug1 = new PrioritizedBug(1,"Logo is not shown",1);
        PrioritizedBug bug2 = new PrioritizedBug(2,"Social media links in the Footer are broken",2);

        System.out.println("Is higher? " + test1.isHigherPriorityThan(test2));
        System.out.println("Is higher? " + bug2.isHigherPriorityThan(bug1));

        System.out.println(bug2.getPriority());
        System.out.println(bug2.getPriorityLabel());
        System.out.println(test2.getPriority());
        System.out.println(test2.getPriorityLabel());

    }
}
