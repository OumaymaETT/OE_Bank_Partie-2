package components;

import java.time.LocalDate;

public class Debit extends Flow {
    public Debit(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, LocalDate date) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
    }
    public Debit() {
        super("", 0, 0.0, 0, false, null);
    }
    @Override
    public String toString() {
        return "Debit{" +
                "comment='" + getComment() + '\'' +
                ", identifier=" + getIdentifier() +
                ", amount=" + getAmount() +
                ", targetAccountNumber=" + getTargetAccountNumber() +
                ", effect=" + isEffect() +
                ", date=" + getDate() +
                '}';
    }
}
