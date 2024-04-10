package edu.ucalgary.oop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) throws IllegalArgumentException {
        setLocation(location);
        this.treatmentDetails = treatmentDetails;

        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format for treatment details. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * Retrieves the location where the treatment took place.
     * @return The location where the treatment took place.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Retrieves the details of the medical treatment.
     * @return Details of the medical treatment.
     */
    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    /**
     * Retrieves the date of the medical treatment.
     * @return The date of the medical treatment in the format "YYYY-MM-DD".
     */
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    /**
     * Sets the location where the treatment took place.
     * @param location The location where the treatment took place.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets the details of the medical treatment.
     * @param treatmentDetails Details of the medical treatment.
     * @throws IllegalArgumentException If the treatment details are invalid.
     */
    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;
    }

    /**
     * Sets the date of the medical treatment.
     */
    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {

        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    /**
     * Checks if the provided date string has a valid format.
     */
    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
