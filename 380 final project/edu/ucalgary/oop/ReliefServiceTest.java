package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReliefServiceTest {
    private ReliefService reliefService;
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private Location lastKnownLocation;
    private String validDate = "2024-02-10";
    private String invalidDate = "2024/02/10";
    private String expectedInfoProvided = "Looking for family member";
    private String expectedLogDetails = "Inquirer: John, Missing Person: Jane Alex, Date of Inquiry: 2024-02-10, Info Provided: Looking for family member, Last Known Location: University of Calgary"; 

    /**
     * setup for the object
     */
    @Before
    public void setUp() {
        inquirer = new Inquirer("John", "Alex", "1234567890", "Looking for family member");
        missingPerson = new DisasterVictim("Jane Alex", "2024-01-25");
        lastKnownLocation = new Location("University of Calgary", "2500 University Dr NW");
        reliefService = new ReliefService(inquirer, missingPerson, validDate, expectedInfoProvided, lastKnownLocation);
    }

    /**
     * test for object creation
     */
    @Test
    public void testObjectCreation() {
        assertNotNull("ReliefService object should not be null", reliefService);
    }

    /**
     * test for get inquirer
     */
    @Test
    public void testGetInquirer() {
        assertEquals("Inquirer should match the one set in setup", inquirer, reliefService.getInquirer());
    }

    /**
     * test for get missing person
     */
    @Test
    public void testGetMissingPerson() {
        assertEquals("Missing person should match the one set in setup", missingPerson, reliefService.getMissingPerson());
    }

    /**
     * test for get date of inquiry
     */
    @Test
    public void testGetDateOfInquiry() {
        assertEquals("Date of inquiry should match the one set in setup", validDate, reliefService.getDateOfInquiry());
    }

    /**
     * test for get information provided
     */
    @Test
    public void testGetInfoProvided() {
        assertEquals("Info provided should match the one set in setup", expectedInfoProvided, reliefService.getInfoProvided());
    }

    /**
     * test for get last known loctation
     */
    @Test
    public void testGetLastKnownLocation() {
        assertEquals("Last known location should match the one set in setup", lastKnownLocation, reliefService.getLastKnownLocation());
    }

    /**
     * test for set date of inquiry with a valid date
     */
    @Test
    public void testSetDateOfInquiryWithValidDate() {
        reliefService.setDateOfInquiry(validDate);
        assertEquals("Setting a valid date should update the date of inquiry", validDate, reliefService.getDateOfInquiry());
    }

    /**
     * test for set date of inquiry with an invalid date
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfInquiryWithInvalidDate() {
        reliefService.setDateOfInquiry(invalidDate);
    }

    /**
     * test for get log details
     */
    @Test
    public void testGetLogDetails() {
        assertEquals("Log details should match the expected format", expectedLogDetails, reliefService.getLogDetails());
    }
    
    
}
