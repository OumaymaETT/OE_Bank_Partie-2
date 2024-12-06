package components;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "client")
public class Client {
	private String name;
    private String firstName;
    private static int clientCounter = 0; 
    private final int clientNumber;

    public Client(String name, String firstName) {
        this.name = name;
        this.firstName = firstName;
        this.clientNumber = ++clientCounter; 
    }
    public Client() {
        this.clientNumber = ++clientCounter; 
    }

    // Getters and Setters
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @XmlElement(name = "clientNumber")
    public int getClientNumber() {
        return clientNumber;
    }

    // toString() method for displaying client details
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", clientNumber=" + clientNumber +
                '}';
    }

}
