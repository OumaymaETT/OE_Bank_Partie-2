package components;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("Transfer")
public class Transfer extends Flow {
    private int issuingAccountNumber;
    public Transfer() {
        super("", 0, 0.0, 0, false, null);
        this.issuingAccountNumber = 0;
    }

    public Transfer(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, LocalDate date, int issuingAccountNumber) {
        super(comment, identifier, amount, targetAccountNumber, effect, date);
        this.issuingAccountNumber = issuingAccountNumber;
    }

    public int getIssuingAccountNumber() {
        return issuingAccountNumber;
    }
    
    public String toString() {
        return "Transfer{" +
                "comment='" + getComment() + '\'' +
                ", identifier=" + getIdentifier() +
                ", amount=" + getAmount() +
                ", targetAccountNumber=" + getTargetAccountNumber() +
                ", effect=" + isEffect() +
                ", date=" + getDate() +
                ", issuingAccountNumber=" + issuingAccountNumber +
                '}';
    }
}


