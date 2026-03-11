package hw4.task1;

import java.util.HashSet;

public class TestStepMain {

    public static void main(String[] args) {

        TestStep testStep1 = new TestStep(1,"Open login page","Page is shown");
        TestStep testStep2 = new TestStep(2,"Enter valid email","Email is shown in the field");
        TestStep testStep3 = new TestStep(3,"Enter valid password","Hidden symbols(dots) are shown in the field");
        TestStep testStep4 = new TestStep(4, "Click on the Login button","Landing page for logined user is shown");
        TestStep testStep5 = new TestStep(4, "Click on the Login button","Landing page for logined user is shown");

        testStep1.markPassed();
        System.out.println(testStep1);

        HashSet<TestStep> hashSet = new HashSet<>();
        hashSet.add(testStep1);
        hashSet.add(testStep2);
        hashSet.add(testStep3);
        hashSet.add(testStep4);
        hashSet.add(testStep5);

        System.out.println(hashSet.size()); // 4. Step 5 was not added

    }
}
