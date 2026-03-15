package hw_date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        UserSubscription userSubscription = new UserSubscription(LocalDate.now().minusWeeks(7),80);

        System.out.println(userSubscription.getExpiryDate());
        System.out.println(userSubscription.isExpired());
        System.out.println(userSubscription.getDaysRemaining());
        System.out.println(userSubscription.getFormattedExpiry());


        System.out.println("======log======");
        TestRunLog log1 = new TestRunLog(LocalDateTime.now().minusMinutes(4),LocalDateTime.now(),"Login");
        System.out.println(log1.getDuration());
        System.out.println(log1.isSlowTest(2));
        System.out.println(log1.toLogLine());
        TestRunLog log2 = TestRunLog.start("Logout");
        System.out.println(log2);
        System.out.println(log2.finish());
        System.out.println(log2); // old unchanged
    }


}
