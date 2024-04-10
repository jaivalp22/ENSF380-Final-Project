package edu.ucalgary.oop;

import java.util.Scanner;

public interface DisasterVictimInterface {
    void enterInformation();
}

class TerminalDisasterVictimInterface implements DisasterVictimInterface {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void enterInformation() {
        System.out.println("Welcome to the Disaster Victim Information System!");
        System.out.println("Please enter the following information:");

        System.out.print("Victim's First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Victim's Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Victim's Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Victim's Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Victim's Comments: ");
        String comments = scanner.nextLine();

        // Enter medical records
        System.out.println("\nEnter Medical Records:");
        System.out.print("Number of Medical Records: ");
        int numRecords = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < numRecords; i++) {
            System.out.println("Medical Record " + (i + 1) + ":");
            System.out.print("Record Type: ");
            String recordType = scanner.nextLine();

            System.out.print("Record Description: ");
            String recordDescription = scanner.nextLine();

            // Create and add medical record
            MedicalRecord medicalRecord = new MedicalRecord(recordType, recordDescription);
            // Add medical record to victim
            // victim.addMedicalRecord(medicalRecord); // Uncomment this line if you have a reference to the victim object
        }

        System.out.println("\nThank you! Victim information entered successfully.");
    }

    public static void main(String[] args) {
        DisasterVictimInterface victimInterface = new TerminalDisasterVictimInterface();
        victimInterface.enterInformation();
    }
}
