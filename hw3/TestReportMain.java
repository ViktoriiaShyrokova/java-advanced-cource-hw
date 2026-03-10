package hw3;

public class TestReportMain {

    public static void main(String[] args) {

        TestReport test1 = new TestReport("User can login with valid login and password");
        TestReport test2 = new TestReport("User cannot login with invalid login");
        TestReport test3 = new TestReport("User cannot login with invalid password");
        TestReport test4 = new TestReport("User is redirected to Profile page after login");
        TestReport test5 = new TestReport("User can change password");
        test1.markPass();
        test2.markPass();
        test3.markFail();
        test4.markFail();
        test5.markSkip();

        System.out.println(TestReport.getSummary());

    }
}
