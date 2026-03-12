package hw5.task2;

public class Main {

    public static void main(String[] args) {

        TestReport testReport = new TestReport("Smoke",378,15);

        testReport.print();
        System.out.println();
        System.out.println(testReport.exportToCsv());
        System.out.println();
        System.out.println("is archived? " + testReport.isArchived());
        testReport.archive();
        System.out.println("is archived? " + testReport.isArchived());


    }
}
