package hw_date;

import javax.swing.text.html.parser.DTDConstants;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class UserSubscription {

    private LocalDate startDate;
    private int durationDays;

    public UserSubscription(LocalDate startDate, int durationDays) {
        this.startDate = startDate;
        this.durationDays = durationDays;
    }

    public LocalDate getExpiryDate() {
        return startDate.plusDays(durationDays);
    }

    public boolean isExpired() {
        return getExpiryDate().isBefore(LocalDate.now());
    }

    public long getDaysRemaining(){
        if(isExpired()) {
            return 0;
        }
        return ChronoUnit.DAYS.between(LocalDate.now(),getExpiryDate());
    }
    public String getFormattedExpiry() {
        return getExpiryDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
