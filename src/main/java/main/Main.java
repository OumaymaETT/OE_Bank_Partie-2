package main;


import com.fasterxml.jackson.databind.ObjectMapper;
import components.Account;
import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;
import components.Flow;
import components.Debit;
import components.Transfer;
import components.Credit;
import components.AccountsWrapper;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println(" --------MAin IMPORTER GIT ---------");
		// Charger les flux depuis un fichier JSON
        String jsonFilePath = "/app/resources/flows.json";
        List<Flow> flows = loadFlowsFromJson(jsonFilePath);
        if (flows != null) {
            System.out.println("=== Flows loaded from JSON ===");
            flows.forEach(System.out::println);
        }

        // Charger les comptes depuis un fichier XML
        String xmlFilePath = "/app/resources/accounts.xml";
        List<Account> accounts = loadAccountsFromXml(xmlFilePath);
        if (accounts != null) {
            System.out.println("=== Accounts loaded from XML ===");
            accounts.forEach(System.out::println);
        }
		//List<Flow> flows = generateFlows();
        //flows.forEach(flow -> System.out.println(flow));
		
		//List<Client> clients = Main.generateClients(3);
       // List<Account> accounts = Main.generateAccounts(clients);

        //displayAccounts(accounts); // Display accounts using streams
		

	}
	
	// Method to generate a list of clients
    public static List<Client> generateClients(int numberOfClients) {
        List<Client> clients = new ArrayList<>();
        for (int i = 1; i <= numberOfClients; i++) {
            clients.add(new Client("Name" + i, "FirstName" + i));
        }
        return clients;
    }

    // Method to display clients using streams
    public static void displayClients(List<Client> clients) {
        clients.stream().forEach(client -> System.out.println(client));
    }
    
 // Generate accounts based on clients
    public static List<Account> generateAccounts(List<Client> clients) {
        List<Account> accounts = new ArrayList<>();
        for (Client client : clients) {
            accounts.add(new CurrentAccount(client));
            accounts.add(new SavingsAccount(client));
        }
        return accounts;
    }

    // Display accounts
    public static void displayAccounts(List<Account> accounts) {
        accounts.stream().forEach(account -> System.out.println(account));
    }
    
 // Generate flows
    public static List<Flow> generateFlows() {
        List<Flow> flows = new ArrayList<>();
        flows.add(new Debit("Debit Flow", 1, 50.0, 1, false, LocalDate.now().plusDays(2)));
        flows.add(new Credit("Credit Flow", 2, 100.50, 2, true, LocalDate.now().plusDays(2)));
        flows.add(new Transfer("Transfer Flow", 3, 50.0, 2, true, LocalDate.now().plusDays(2), 1));
        return flows;
    }
    
 //Method to load  from a JSON file
    public static List<Flow> loadFlowsFromJson(String filePath) {
        List<Flow> flows = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules(); 
            flows = objectMapper.readValue(new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Flow.class));
            System.out.println("Flows loaded successfully from JSON file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flows;
    }


   // Method to load accounts from an XML file
    public static List<Account> loadAccountsFromXml(String filePath) {
        List<Account> accounts = new ArrayList<>();
        try {
            JAXBContext context = JAXBContext.newInstance(AccountsWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AccountsWrapper wrapper = (AccountsWrapper) unmarshaller.unmarshal(new File(filePath));
            accounts.addAll(wrapper.getAccounts());
            System.out.println("Accounts loaded successfully from XML file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
