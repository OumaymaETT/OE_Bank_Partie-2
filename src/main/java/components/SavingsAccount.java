package components;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "savingsAccount")
public class SavingsAccount extends Account {
    public SavingsAccount(Client client) {
        super("Savings Account", client);
    }
    public SavingsAccount() {
        super("", null);
    }

}
