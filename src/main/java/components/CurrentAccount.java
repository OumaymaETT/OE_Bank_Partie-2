package components;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "currentAccount")
public class CurrentAccount extends Account{
	public CurrentAccount(Client client) {
        super("Current Account", client);
    }
	public CurrentAccount() {
        super("", null); 
    }
}
