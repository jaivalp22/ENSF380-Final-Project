import java.util.Scanner;

public class DisasterManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Disaster Management System!");

        // Create an initial victim
        System.out.println("Let's create a new disaster victim.");
        System.out.print("Enter victim's first name: ");
        System.out.print("Date:");
        String firstName = scanner.nextLine();
        String ENTRY_DATE = scanner.nextLine();
        DisasterVictim victim = new DisasterVictim(firstName, ENTRY_DATE);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add family connection");
            System.out.println("2. Remove family connection");
            System.out.println("3. Display victim details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addFamilyConnection(victim, scanner);
                    break;
                case 2:
                    removeFamilyConnection(victim, scanner);
                    break;
                case 3:
                    displayVictimDetails(victim);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Disaster Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    private static void addFamilyConnection(DisasterVictim victim, Scanner scanner) {
        System.out.print("Enter family member's first name: ");
        String familyMemberFirstName = scanner.nextLine();

        // Add family connection
        victim.addFamilyConnection(new FamilyRelation(victim, "relative", new DisasterVictim(familyMemberFirstName, "2024-04-08")));

        System.out.println("Family connection added successfully!");
    }

    private static void removeFamilyConnection(DisasterVictim victim, Scanner scanner) {
        System.out.print("Enter family member's first name to remove connection: ");
        String familyMemberFirstName = scanner.nextLine();

        // Remove family connection
        victim.removeFamilyConnection(new FamilyRelation(victim, "relative", new DisasterVictim(familyMemberFirstName, "2024-04-08")));

        System.out.println("Family connection removed successfully!");
    }

    private static void displayVictimDetails(DisasterVictim victim) {
        System.out.println("\nVictim Details:");
        System.out.println("First Name: " + victim.getFirstName());
        System.out.println("Entry Date: " + victim.getEntryDate());
        System.out.println("Social ID: " + victim.getAssignedSocialID());
        System.out.println("Family Connections: ");
        for (FamilyRelation relation : victim.getFamilyConnections()) {
            System.out.println("- " + relation.getPersonTwo().getFirstName() + " (" + relation.getRelationshipTo() + ")");
        }
    }
}
