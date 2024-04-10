package edu.ucalgary.oop;

import java.util.Scanner;
import java.util.*;
import java.sql.*;


public class Main {
    private Connection dbConnect;
    private static Scanner scanner = new Scanner(System.in);
    private ResultSet result;

    public void location() {
        System.out.println("Welcome to the Disaster Management Hub");

        while (true) {
            System.out.println("\nSelect an action by entering the corresponding number:");
            System.out.println("1. Register a new Disaster Victim");
            System.out.println("2. Establish a Family Connection");
            System.out.println("3. Add Medical Record Medical");
            System.out.println("4. Exit");
        
        
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if (option == 1) {
                addDisasterVictim();
            } else if (option == 2) {
                addFamilyConnection();
            } else if (option == 3) {
                addMedicalRecord();
            } else if (option == 4) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    
    public void centralMain(){
        HashSet<Location> locationList = new HashSet<>();
        Location Telusspark = new Location("Telus Spark", "123 Main Street");
        Location Shawnessymall = new Location("Shawnessy mall", "16th Ave");
        DisasterVictim John = new DisasterVictim("John", "2022-10-08");
        DisasterVictim James = new DisasterVictim("James", "2024-08-19");
        DisasterVictim Robert = new DisasterVictim("Robert", "2023-06-20");
        DisasterVictim Amy = new DisasterVictim("Amy", "2023-4-22");
        Telusspark.addOccupant(John);
        Telusspark.addOccupant(James);
        Shawnessymall.addOccupant(Robert);
        Shawnessymall.addOccupant(Amy);
        locationList.add(Telusspark);
        locationList.add(Shawnessymall);
    
        System.out.println("Welcome to the Central Disaster Management System");

        while (true) {
            System.out.println("\nChoose an option (type the number):");
            System.out.println("1. Search for a Disaster Victim");
            System.out.println("2. Log an Inquirer's Query");
            System.out.println("3. Exit");
        
            int option = scanner.nextInt();
            scanner.nextLine();
            
            if (option == 1) {
                SearchDisasterVictim(locationList);
            } else if (option == 2) {
                inquirerSQLInteracter();
            } else if (option == 3) {
                System.out.println("Exiting...");
                return;
            } else {
                System.out.println("Invalid option. Please choose again.");
            }
        }
    }
    

    private static Location createLocation(String name, String address) {
        return new Location(name, address);
    }
    private static DisasterVictim createVictim(String firstName, String lastName) {
        return new DisasterVictim(firstName, lastName, "2024-03-21");
    }
    private static void addDisasterVictim() {
        System.out.println("Enter victim's information:");
        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        System.out.println("Location's name:");
        String locationName = scanner.nextLine();
        System.out.println("Location's address:");
        String locationAddress = scanner.nextLine();
        Location victimLocation = createLocation(locationName, locationAddress);
        DisasterVictim victim = createVictim(firstName, lastName);
        victimLocation.addOccupant(victim);
        System.out.println("Disaster Victim added successfully!");
    }

    private static void addFamilyConnection() {
        DisasterVictim primaryPerson = getPersonDetails("primary");
        DisasterVictim relatedPerson = getPersonDetails("related");
    
        if (primaryPerson != null && relatedPerson != null) {
            establishFamilyConnection(primaryPerson, relatedPerson);
        } else {
            System.out.println("Failed to add family connection.");
        }
    }
        
    private static void establishFamilyConnection(DisasterVictim primaryPerson, DisasterVictim relatedPerson) {
        System.out.println("Enter the relationship between the primary person and the related person:");
        System.out.println("child");
        System.out.println("parent");
        System.out.println("spouse");
        System.out.println("sibling");
        System.out.println("Type the relationship from primary person to the related person:");
        String relation = scanner.nextLine();
    
        primaryPerson.addFamilyConnection(new FamilyRelation(primaryPerson, relation, relatedPerson));
        System.out.println("Family connection added successfully!");
    }

    private static DisasterVictim getPersonDetails(String personType) {
        System.out.println("Enter " + personType + " person's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter " + personType + " person's last name:");
        String lastName = scanner.nextLine();
        System.out.println("Enter " + personType + " person's date of birth (YYYY-MM-DD):");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Enter " + personType + " person's entry date (YYYY-MM-DD):");
        String entryDate = scanner.nextLine();
        return new DisasterVictim(firstName, lastName, dateOfBirth, entryDate);
    }

    private static String getVictimFirstName() {
        System.out.println("Enter victim's first name:");
        return scanner.nextLine();
    }
    
    private static String getVictimLastName() {
        System.out.println("Enter victim's last name:");
        return scanner.nextLine();
    }
    
    private static void addMedicalRecord() {
        String victimFirstName = getVictimFirstName();
        String victimLastName = getVictimLastName();
        Location location = getLocationDetails();
        String dateOfBirth = getVictimDateOfBirth();
        String entryDate = getVictimEntryDate();
        DisasterVictim Victim = getOrCreateVictim(victimFirstName, victimLastName, location, dateOfBirth, entryDate);
        Location treatmentLocation = getTreatmentLocation();
        String treatmentDetails = getTreatmentDetails();
        String dateOfTreatment = getDateOfTreatment();
        createMedicalRecord(Victim, treatmentLocation, treatmentDetails, dateOfTreatment);
    
        System.out.println("Medical record added successfully!");
    }
    
    private static String getVictimDateOfBirth() {
        System.out.println("Enter victim's date of birth (YYYY-MM-DD):");
        return scanner.nextLine();
    }
    
    private static String getVictimEntryDate() {
        System.out.println("Enter victim's entry date (YYYY-MM-DD):");
        return scanner.nextLine();
    }
    
    private static Location getLocationDetails() {
        System.out.println("Enter the location's name:");
        String locationName = scanner.nextLine();
    
        System.out.println("Enter the address of the location:");
        String locationAddress = scanner.nextLine();
    
        return new Location(locationName, locationAddress);
    }
    
    private static DisasterVictim getOrCreateVictim(String firstName, String lastName, Location location, String dateOfBirth, String entryDate) {
        for (DisasterVictim occupant : location.getOccupants()) {
            if (occupant.getFirstName().equals(firstName) && occupant.getLastName().equals(lastName)) {
                return occupant;
            }
        }
        DisasterVictim victim = new DisasterVictim(firstName, lastName, dateOfBirth, entryDate);
        location.addOccupant(victim);
        return victim;
    }
    
    
    private static String getTreatmentDetails() {
        System.out.println("Enter treatment details:");
        return scanner.nextLine();
    }

    private static Location getTreatmentLocation() {
        System.out.println("Enter location of treatment:");
        String treatmentLocationName = scanner.nextLine();
    
        System.out.println("Enter address of the location of treatment:");
        String treatmentLocAddress = scanner.nextLine();
    
        return new Location(treatmentLocationName, treatmentLocAddress);
    }
    
    private static String getDateOfTreatment() {
        System.out.println("Enter date of treatment (YYYY-MM-DD):");
        return scanner.nextLine();
    }

    private static void SearchDisasterVictim(HashSet<Location> locations){
        System.out.println("Enter the name of the person you are looking for.");
        System.out.println("(You can search up part of the name, if you dont know thespelling):");
        String victimName = scanner.nextLine();
        findDisasterVictims(locations, victimName);

    }
    
    private static void createMedicalRecord(DisasterVictim victim, Location treatmentLocation, String treatmentDetails, String dateOfTreatment) {
        victim.addMedicalRecord(new MedicalRecord(treatmentLocation, treatmentDetails, dateOfTreatment));
    }

    private static ArrayList<String> findVictimsInLocation(Location location, String partialName) {
        ArrayList<String> matchingNames = new ArrayList<>();
    
        for (DisasterVictim occupant : location.getOccupants()) {
            String occupantName = occupant.getFirstName().toLowerCase();
    
            if (occupantName.contains(partialName)) {
                matchingNames.add(occupant.getFirstName());
            }
        }
    
        return matchingNames;
    }

    private static ArrayList<String> findDisasterVictims(HashSet<Location> locations, String name) {
        String partialName = name.toLowerCase();
        ArrayList<String> matchingNames = new ArrayList<>();
    
        for (Location location : locations) {
            ArrayList<String> locationMatchingNames = findVictimsInLocation(location, partialName);
            matchingNames.addAll(locationMatchingNames);
        }
    
        return matchingNames;
    }

    private Inquirer getInquirerDetails() {
        System.out.println("Give me firstname and lastname (if known), phonenumber in the form of (XXX-XXX-XXXX), the date of inquiry(YYYY-MM-DD),");
        System.out.println("and the information given of the inquirer you wish to search for:");
    
        String firstName = getValidInput("Firstname:");
        String lastName = getValidInput("Lastname (optional):");
        String phoneNumber = getValidPhoneNumber("Phone-number:");
        String dateOfInquiry = getValidDate("Date of Inquiry (YYYY-MM-DD):");
        String inquirerInfo = getValidInput("Inquirer Info:");
    
        return new Inquirer(firstName, lastName, phoneNumber, inquirerInfo);
    }
    
    private void inquirerSQLInteracter() {
        System.out.println("Do you want to interact with the database? (yes/no)");
        String response = scanner.nextLine().toLowerCase();
    
        if (response.equals("yes")) {
            Inquirer inquirer = getInquirerDetails();
    
            logInquirerQuery(inquirer);
    
            System.out.println("Inquirer successfully added!!!!");
        }
    }
    
    private String getValidInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
    private String getValidPhoneNumber(String prompt) {
        String phoneNum;
        boolean validPhone = false;
        String phoneFormatPattern = "^\\d{3}-\\d{3}-\\d{4}$";
        while (!validPhone) {
            phoneNum = getValidInput(prompt);
            if (phoneNum.matches(phoneFormatPattern)) {
                validPhone = true;
                return phoneNum;
            } else {
                System.out.println("Invalid phone number format. Please use XXX-XXX-XXXX format.");
            }
        }
        return null;
    }
    
    private String getValidDate(String prompt) {
        String dateOfInquiry;
        boolean validDate = false;
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        while (!validDate) {
            dateOfInquiry = getValidInput(prompt);
            if (dateOfInquiry.matches(dateFormatPattern)) {
                validDate = true;
                return dateOfInquiry;
            } else {
                System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
        return null;
    }
    
    private void logInquirerQuery(Inquirer inquirer) {
        
    }
    public void logInquirerQuery(Inquirer newInquirer, String dateofinq, String inqinfo) {
        int inquirerID = checkexistinginquirer(newInquirer);
        if (inquirerID != 0) {
            addtoInquiryLog(inquirerID, dateofinq, inqinfo);
        }
        else {
            addNewInquirer(newInquirer);
            int newinquirerID = checkexistinginquirer(newInquirer);
            addtoInquiryLog(newinquirerID, dateofinq, inqinfo);
        }
    }


    private void addNewInquirer(Inquirer newInquirer) {
        try {
            int newInquirerID = getNextInquirerID();
    
            String query;
            if (newInquirer.getLastName() == null) {
                query = "INSERT INTO inquirer (id, firstName, phoneNumber) VALUES (?,?,?)";
            } else {
                query = "INSERT INTO inquirer (id, firstName, lastName, phoneNumber) VALUES (?,?,?,?)";
            }
    
            // Create and execute the prepared statement
            PreparedStatement insertStmt = dbConnect.prepareStatement(query);
            insertStmt.setInt(1, newInquirerID);
            insertStmt.setString(2, newInquirer.getFirstName());
            if (newInquirer.getLastName() != null) {
                insertStmt.setString(3, newInquirer.getLastName());
            }
            insertStmt.setString(newInquirer.getLastName() == null ? 3 : 4, newInquirer.getServicesPhoneNum());
    
            insertStmt.executeUpdate();
            insertStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private int getNextInquirerID() throws SQLException {
        Statement maxIdStmt = dbConnect.createStatement();
        ResultSet maxIdResult = maxIdStmt.executeQuery("SELECT MAX(id) FROM inquirer");
        int maxId = 0;
        if (maxIdResult.next()) {
            maxId = maxIdResult.getInt(1);
        }
        maxIdResult.close();
        maxIdStmt.close();
    
        return maxId + 1;
    }
    
    

    public void createConnection(){
        try{
            dbConnect = DriverManager.getConnection("jdbc:postgresql://localhost/ensf380project", "oop", "ucalgary");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getNextInquiryLogID() throws SQLException {
        Statement maxIdStmt = dbConnect.createStatement();
        ResultSet maxIdResult = maxIdStmt.executeQuery("SELECT MAX(id) FROM inquiry_log");
        int maxInquiryLogID = 0;
        if (maxIdResult.next()) {
            maxInquiryLogID = maxIdResult.getInt(1);
        }
        maxIdResult.close();
        maxIdStmt.close();
    
        return maxInquiryLogID + 1;
    }

    private void addtoInquiryLog(int inquirerID, String date, String info) {
        try {
            int newLogID = getNextInquiryLogID();
    
            java.sql.Date dateOfInquiry = java.sql.Date.valueOf(date);
    
            String query = "INSERT INTO inquiry_log (id, inquirer, callDate, details) VALUES (?,?,?,?)";
            PreparedStatement insertStmt = dbConnect.prepareStatement(query);
            insertStmt.setInt(1, newLogID);
            insertStmt.setInt(2, inquirerID);
            insertStmt.setDate(3, dateOfInquiry);
            insertStmt.setString(4, info);
    
            insertStmt.executeUpdate();
            insertStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public void close() {
        try {
            result.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int checkexistinginquirer(Inquirer person) {
        int id = 0;
        try {
            String query = "SELECT id FROM inquirer WHERE firstname = ? AND phonenumber = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, person.getFirstName());
            myStmt.setString(2, person.getServicesPhoneNum());
    
            ResultSet result = myStmt.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
    

    public static void main(String[] args) {
        Main generalMain = new Main();
    
        boolean exit = false;
    
        while (!exit) {
            System.out.println("Welcome to the Disaster Management System!");
    
            System.out.println("Choose your mode of operation:");
            System.out.println("1. Location-based relief worker");
            System.out.println("2. Central-based relief worker");
            System.out.println("3. Exit");
    
            int mode = scanner.nextInt();
            scanner.nextLine();
    
            if (mode == 1) {
                generalMain.location();
            } else if (mode == 2) {
                generalMain.centralMain();
            } else if (mode == 3) {
                exit = true;
                System.out.println("Exiting the Disaster Management System...");
            } else {
                System.out.println("Invalid choice. Please select again.");
            }
        }
    
        scanner.close();
    }
    
}