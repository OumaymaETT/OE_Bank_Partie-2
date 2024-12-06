package components;
import javax.xml.bind.annotation.XmlElement;

public abstract class Account {
	
	protected String label;
    protected double balance;
    protected static int accountCounter = 0; // Auto-increment for unique account number
    protected final int accountNumber;
    @XmlElement(name = "client")
    protected Client client;

    public Account(String label, Client client) {
        this.label = label;
        this.client = client;
        this.accountNumber = ++accountCounter; // Unique account number
        this.balance = 0.0; // Default balance
    }

    // Getters and Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        this.balance += amount; // Modify balance
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "label='" + label + '\'' +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                ", client=" + client +
                '}';
    }

}
