package hw7.task_01;

import java.lang.reflect.Method;

public class TestFilter {

    public static void printByType(Class<?> testClass) {
        for (Method method : testClass.getDeclaredMethods()) {
            boolean isSmoke = method.isAnnotationPresent(Smoke.class);
            boolean isRegression = method.isAnnotationPresent(Regression.class);
            String type = "";
            if(isSmoke && isRegression) {
                type = "SMOKE+REGRESSION";
            } else if (isSmoke) {
                type = "SMOKE";
            } else if (isRegression) {
                type = "REGRESSION";
            }else type = "UNTAGGED";
            System.out.println("Method: " + method.getName() + " - " + type);
        }
    }
}
