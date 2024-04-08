/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        setDateOfInquiry(dateOfInquiry);
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }

    public Inquirer getInquirer() {
        return inquirer;
    }

    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    public String getDateOfInquiry() {
        return dateOfInquiry;
    }

    public String getInfoProvided() {
        return infoProvided;
    }

    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    public void setDateOfInquiry(String dateOfInquiry) {

        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getLogDetails() {
       return "Inquirer: " + inquirer.getFirstName() + 
           ", Missing Person: " + missingPerson.getFirstName() + 
           ", Date of Inquiry: " + dateOfInquiry + 
           ", Info Provided: " + infoProvided + 
           ", Last Known Location: " + lastKnownLocation.getName();
}
}
