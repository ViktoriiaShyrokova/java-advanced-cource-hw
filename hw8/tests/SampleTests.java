package hw8.tests;

import org.example.annotations.MyAfterEach;
import org.example.annotations.MyBeforeEach;
import org.example.annotations.MyDisabled;
import org.example.annotations.MyTest;

// Этот класс - просто набор тестовых методов
public class SampleTests {

    @MyBeforeEach
    public void setUp() {
        System.out.println(" [setup] Preparing test environment...");
    }

    @MyAfterEach
    public void tearDown() {
        System.out.println(" [teardown] Cleaning up...");
    }

    // Test 1
    @MyTest
    public void loginWithValidCredentials() {
        System.out.println("   Testing login...");
    }

    @MyTest
    public void productPriceIsPositive() {
        System.out.println("   Testing product price...");
        double price = 100.0;
        if (price <= 0)
            System.out.println("    Price must be positive, but was: " + price);
    }

    @MyTest
    public void paymentWithExpiredCard() {
        System.out.println("    Testing expired card payment...");
        throw new RuntimeException("Payment service unavailable");
    }

    @MyTest
    @MyDisabled(reason = "JIRA-123: Feature not implemented yet")
    public void refundProcessing() {
        System.out.println("    Testing refund...");
    }

    public void helperMethod() {
        System.out.println("This is a helper, not a test");
    }
}
