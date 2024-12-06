package components;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"
	)
	@JsonSubTypes({
	    @JsonSubTypes.Type(value = Debit.class, name = "Debit"),
	    @JsonSubTypes.Type(value = Credit.class, name = "Credit"),
	    @JsonSubTypes.Type(value = Transfer.class, name = "Transfer")
	})
public abstract class Flow {
	private String comment;
    private int identifier;
    private double amount;
    private int targetAccountNumber;
    private boolean effect;
    private LocalDate date;

    public Flow(String comment, int identifier, double amount, int targetAccountNumber, boolean effect, LocalDate date) {
        this.comment = comment;
        this.identifier = identifier;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
        this.effect = effect;
        this.date = date;
    }

    // Getters and Setters
    public String getComment() {
        return comment;
    }

    public int getIdentifier() {
        return identifier;
    }

    public double getAmount() {
        return amount;
    }

    public int getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public boolean isEffect() {
        return effect;
    }

    public LocalDate getDate() {
        return date;
    }

}
