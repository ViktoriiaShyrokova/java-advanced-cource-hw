package hw8.runner;

import hw8.annotations.MyAfterEach;
import hw8.annotations.MyBeforeEach;
import hw8.annotations.MyDisabled;
import hw8.annotations.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyTestRunner {

    private static final Logger logger = Logger.getLogger(MyTestRunner.class.getName());

    public static void run(Class<?> testClass) throws Exception {
        logger.info("Starting test execution for class: " + testClass.getSimpleName());
        System.out.println("=== Running: " + testClass.getSimpleName() + " ===\n");

        // Step 1: Create instance by Singleton
        logger.info("Test instance created successfully");
        Object instance = testClass.getDeclaredConstructor().newInstance();

        // Step 2: Get all methods of instance
        logger.info("Retrieving all methods from class");
        Method[] allMethods = testClass.getDeclaredMethods();
        logger.fine("Retrieved " + allMethods.length + " methods from class");

        // Step 3: Find methods - setUp() and tearDown()
        logger.info("Searching for lifecycle methods (@BeforeEach, @AfterEach)");
        logger.fine("Initializing setUp() and tearDown() methods");
        Method beforeEach = null;
        Method afterEach = null;
        logger.fine("Looping through all methods");
        for (Method method : allMethods) {
            logger.fine("Checking method: " + method.getName());
            logger.finer("Checking MyBeforeEach annotation");
            if (method.isAnnotationPresent(MyBeforeEach.class)) {
                logger.finer("Found MyBeforeEach annotation");
                beforeEach = method;
            }
            logger.finer("Checking MyAfterEach annotation");
            if (method.isAnnotationPresent(MyAfterEach.class)) {
                logger.finer("Found MyAfterEach annotation");
                afterEach = method;
            }
        }

        // Step 4: Create list of test-method
        List<Method> testMethods = new ArrayList<>();
        logger.info("Found " + testMethods.size() + " test methods");
        logger.fine("Initializing list of test-method");
        logger.fine("Looping through all methods");
        for (Method method : allMethods) {
            logger.finer("Checking method: " + method.getName());
            logger.finer("Checking MyTest annotation");
            if (method.isAnnotationPresent(MyTest.class)) {
                logger.finer("Adding method to the list");
                testMethods.add(method);
            }
        }

        // Step 5: Create counter of test
        logger.info("Initializing test counters");
        logger.fine("Initializing counter of test");
        int passed = 0;
        int skipped = 0;
        int failed = 0;

        // Step 6: Loop of test methods and run them
        logger.info("Starting test execution loop");
        logger.fine("Looping through test methods");
        for (Method testMethod : testMethods) {
            logger.finer("Checking method: " + testMethod.getName());
            logger.finer("Checking MyDisabled annotation");
            // Check for MyDisabled
            if (testMethod.isAnnotationPresent(MyDisabled.class)) {
                logger.finer("Found MyDisabled annotation");
                MyDisabled disabled = testMethod.getAnnotation(MyDisabled.class);
                logger.finer("Getting reason");
                String reason = disabled.reason();

                // Output message
                logger.fine("Output skip message for disabled test");
                if (reason.isEmpty()) {
                    logger.info("Test skipped: " + testMethod.getName());
                    System.out.println("[SKIPPED] " + testMethod.getName());
                } else {
                    logger.info("Test skipped with reason: " + testMethod.getName() + " - " + reason);
                    System.out.println("[SKIPPED] " + testMethod.getName() + ": " + reason);
                }

                logger.fine("Incrementing skipped counter");
                skipped++;
                logger.fine("Continuing to next test method");
                continue;
            }
            logger.info("Executing test: " + testMethod.getName());
            if (beforeEach != null) {
                logger.fine("Running beforeEach method: " + beforeEach.getName());
                beforeEach.invoke(instance);
                logger.fine("BeforeEach method completed successfully");
            }

            logger.fine("Invoking test method: " + testMethod.getName());
            try {
                testMethod.invoke(instance);
                logger.info("Test passed: " + testMethod.getName());
                System.out.println("[PASSED] " + testMethod.getName());
                passed++;
            } catch (InvocationTargetException e) {
                logger.warning("Test failed: " + testMethod.getName() + " - " + e.getCause().getMessage());
                System.out.println("[FAILED] " + testMethod.getName() + ": " + e.getCause().getMessage());
                failed++;
            }

            if (afterEach != null) {
                logger.fine("Running afterEach method: " + afterEach.getName());
                afterEach.invoke(instance);
                logger.fine("AfterEach method completed successfully");
            }

            System.out.println();
        }

        int total = passed + skipped + failed;

        logger.info("Test execution completed. Total: " + total + ", Passed: " + passed + ", Failed: " + failed + ", Skipped: " + skipped);
        System.out.printf("Total: %d | Passed: %d | Failed: %d | Skipped: %d%n",
                total, passed, failed, skipped);
    }
}











