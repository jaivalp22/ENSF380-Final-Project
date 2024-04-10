package edu.ucalgary.oop;

import java.util.List;
import java.util.Scanner;

public interface inquierInterface {
    void logQuery(String query);
    List<DisasterVictim> searchVictimsByName(String query);
}

class TerminalInquirerInterface implements inquierInterface {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void logQuery(String query) {
        System.out.println("Query logged: " + query);
    }

    @Override
    public List<DisasterVictim> searchVictimsByName(String query) {
        // Perform case-insensitive search for victims by name
        String queryLowercase = query.toLowerCase();
        List<DisasterVictim> matchingVictims = new ArrayList<>();

        for (DisasterVictim victim : allVictims) {
            String fullName = victim.getFirstName() + " " + victim.getLastName();
            if (fullName.toLowerCase().contains(queryLowercase)) {
                matchingVictims.add(victim);
            }
        }

        return matchingVictims;
    }

    public static void main(String[] args) {
        TerminalInquirerInterface inquirerInterface = new TerminalInquirerInterface();
        inquirerInterface.logQuery("Sample query logged.");

        System.out.println("\nSearch for DisasterVictims:");
        System.out.print("Enter a part of the name to search: ");
        String searchQuery = scanner.nextLine();

        List<DisasterVictim> searchResults = inquirerInterface.searchVictimsByName(searchQuery);
        if (searchResults.isEmpty()) {
            System.out.println("No matching DisasterVictims found.");
        } else {
            System.out.println("Matching DisasterVictims found:");
            for (DisasterVictim victim : searchResults) {
                System.out.println(victim.getFirstName() + " " + victim.getLastName());
            }
        }
    }
}
