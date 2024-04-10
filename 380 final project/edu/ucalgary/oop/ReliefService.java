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

    /**
     * Retrieves the inquirer associated with this ReliefService.
     * @return The inquirer making the inquiry.
     */
    public Inquirer getInquirer() {
        return inquirer;
    }

    /**
     * Retrieves the missing person associated with this ReliefService.
     * @return The missing person being searched for.
     */
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }

    /**
     * Retrieves the date of the inquiry.
     * @return The date of the inquiry in the format "YYYY-MM-DD".
     */
    public String getDateOfInquiry() {
        return dateOfInquiry;
    }

    /**
     * Retrieves the information provided regarding the missing person.
     * @return Information provided regarding the missing person.
     */
    public String getInfoProvided() {
        return infoProvided;
    }

    /**
     * Retrieves the last known location of the missing person.
     * @return The last known location of the missing person.
     */
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    /**
     * Sets the inquirer associated with this ReliefService.
     * @param inquirer The inquirer making the inquiry.
     */
    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }

    /**
     * Sets the missing person associated with this ReliefService.
     * @param missingPerson The missing person being searched for.
     */
    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    /**
     * Sets the date of the inquiry.
     * @param dateOfInquiry The date of the inquiry in the format "YYYY-MM-DD".
     * @throws IllegalArgumentException If the provided date format is invalid.
     */
    public void setDateOfInquiry(String dateOfInquiry) {
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date format for date of inquiry. Expected format: YYYY-MM-DD");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    /**
     * Sets the information provided regarding the missing person.
     * @param infoProvided Information provided regarding the missing person.
     */
    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }

    /**
     * Sets the last known location of the missing person.
     * @param lastKnownLocation The last known location of the missing person.
     */
    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    /**
     * Checks if the provided date string has a valid format.
     * @param date The date string to be validated.
     * @return True if the date string has a valid format, otherwise false.
     */
    public boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves a string containing details of the relief service log.
     * @return A string containing details of the relief service log.
     */
    public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() + 
               ", Missing Person: " + missingPerson.getFirstName() + 
               ", Date of Inquiry: " + dateOfInquiry + 
               ", Info Provided: " + infoProvided + 
               ", Last Known Location: " + lastKnownLocation.getName();
    }
}
