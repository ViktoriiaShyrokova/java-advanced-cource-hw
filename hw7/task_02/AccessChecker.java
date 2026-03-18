package hw7.task_02;

import hw7.task_01.Regression;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AccessChecker {

    public static boolean canAccess(Class<?> service, String methodName, String userRole) throws NoSuchMethodException {

        Method method = null;
        for (Method declaredMethod : service.getDeclaredMethods()) {
            if (declaredMethod.getName().equals(methodName)) {
                method = declaredMethod;
                break;
            }
        }
        if (method == null) {
            throw new NoSuchMethodException("Method " + methodName + " not found");
        }

        if (method.isAnnotationPresent(RequiresRole.class)) {
            RequiresRole role = method.getAnnotation(RequiresRole.class);
            return Arrays.asList(role.value()).contains(userRole);
        }
        return true;

    }
}
