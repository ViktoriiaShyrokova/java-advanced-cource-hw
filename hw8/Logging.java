package hw8;

import hw8.runner.MyTestRunner;

public class Logging {

    MyTestRunner delegate;

    public Logging(MyTestRunner delegate) {
        this.delegate = delegate;
    }

    public void run(Class<?> testClass) throws Exception {
        delegate.run(testClass);
    }

}
