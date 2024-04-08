/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

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

    public Location getLocation() {
        return location;
    }

    public String getTreatmentDetails() {
        return treatmentDetails;
    }

    public String getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTreatmentDetails(String treatmentDetails) throws IllegalArgumentException {
        this.treatmentDetails = treatmentDetails;
    }

    public void setDateOfTreatment(String dateOfTreatment) throws IllegalArgumentException {

        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: YYYY-MM-DD");
        }
        this.dateOfTreatment = dateOfTreatment;
    }

    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

