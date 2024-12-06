package components;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import javax.xml.bind.annotation.XmlSeeAlso;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "accounts")
@XmlSeeAlso({CurrentAccount.class, SavingsAccount.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountsWrapper {
	@XmlElement(name = "account")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
