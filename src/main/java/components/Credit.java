package components;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("Credit")
public class Credit extends Flow {
    public Credit(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, LocalDate date) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
    }
    public Credit() {
        super("", 0, 0.0, 0, false, null);
    }
    public String toString() {
        return "Credit{" +
                "comment='" + getComment() + '\'' +
                ", identifier=" + getIdentifier() +
                ", amount=" + getAmount() +
                ", targetAccountNumber=" + getTargetAccountNumber() +
                ", effect=" + isEffect() +
                ", date=" + getDate() +
                '}';
    }
}

