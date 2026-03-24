package hw8;

import hw8.runner.MyTestRunner;
import hw8.tests.SampleTests;

public class Main {
    public static void main(String[] args) throws Exception {
        MyTestRunner.run(SampleTests.class);
    }
}
