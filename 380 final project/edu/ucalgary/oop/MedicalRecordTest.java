package edu.ucalgary.oop;
import org.junit.Test;
import static org.junit.Assert.*;

public class MedicalRecordTest {
    
    Location expectedLocation = new Location("ShelterA", "148 Ave NE ");
    private String expectedTreatmentDetails = "Broken leg treated";
    private String expectedDateOfTreatment = "2024-01-09";
    private String validDateOfTreatment = "2024-02-14";
    private String inValidDateOfTreatment = "2024/02/14";
    MedicalRecord medicalRecord = new MedicalRecord(expectedLocation, expectedTreatmentDetails, expectedDateOfTreatment);


    /**
     * test for medical records null or not
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(medicalRecord);
    }	
	
    /**
     * test for location
     */
    @Test
    public void testGetLocation() {
    assertEquals("getLocation should return the correct Location", expectedLocation, medicalRecord.getLocation());
    }

    /**
     * test for set loction
     */
    @Test
    public void testSetLocation() {
	Location newExpectedLocation = new Location("Shelter B", "150 8 Ave NW ");
	medicalRecord.setLocation(newExpectedLocation);
        assertEquals("setLocation should update the Location", newExpectedLocation.getName(), medicalRecord.getLocation().getName());
    }

    /**
     * test for get treatement details
     */
    @Test
    public void testGetTreatmentDetails() {
        assertEquals("getTreatmentDetails should return the correct treatment details", expectedTreatmentDetails, medicalRecord.getTreatmentDetails());
    }
    /**
     * test for set treatment details
     */
    @Test
    public void testSetTreatmentDetails() {
	String newExpectedTreatment = "No surgery required";
	medicalRecord.setTreatmentDetails(newExpectedTreatment);
    assertEquals("setTreatmentDetails should update the treatment details", newExpectedTreatment, medicalRecord.getTreatmentDetails());
    }


    /**
     * test for get date of treatment
     */
    @Test
    public void testGetDateOfTreatment() {
    assertEquals("getDateOfTreatment should return the correct date of treatment", expectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
	
	/**
	 * test for set date of treatment
	 */
	@Test
    public void testSetDateOfTreatment() {
	String newExpectedDateOfTreatment = "2024-02-05";
	medicalRecord.setDateOfTreatment(newExpectedDateOfTreatment);
    assertEquals("setDateOfTreatment should update date of treatment", newExpectedDateOfTreatment, medicalRecord.getDateOfTreatment());
    }
	/**
	 * test for valid date format
	 */
	@Test
    public void testSetDateOfTreatmentWithValidFormat() {
        
        medicalRecord.setDateOfTreatment(validDateOfTreatment);
    }

    /**
     * test for invalid format
     */
    @Test
    public void testSetDateOfBirthWithInvalidFormat() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(inValidDateOfTreatment);
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid date format '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    /**
     * test for date of birth without a date
     */
    @Test
    public void testSetDateOfBirthWithNotADate() {
        boolean correctValue = false;
        String failureReason = "no exception was thrown";

        try {
           medicalRecord.setDateOfTreatment(expectedTreatmentDetails);
        }
        catch (IllegalArgumentException e) {
           correctValue = true;
        }
        catch (Exception e) {
           failureReason = "the wrong type of exception was thrown";
        }

        String message = "setDateOfTreatment() should throw an IllegalArgumentException with invalid non-date input '" + inValidDateOfTreatment + "' but " + failureReason + ".";
        assertTrue(message, correctValue);
    }

    
}
