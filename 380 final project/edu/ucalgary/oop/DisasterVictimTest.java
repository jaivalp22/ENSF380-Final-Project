package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private DisasterVictim victim1;
    private DisasterVictim victim2;
    private Vector<MedicalRecord> medicalRecords = new Vector<>();
    private HashSet<Supply> suppliesToSet = new HashSet<>();
    private String expectedFirstName = "Freda";
    private int age;
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedComments = "Needs medical attention and speaks 2 languages";
    private static ArrayList<String> genderoptions = DisasterVictim.GenderOptionsfiles();

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));

        victim1 = new DisasterVictim("Jane", "2024-01-20");
        victim2 = new DisasterVictim("John", "2024-01-22");
    }

    /**
     * Tests the constructor with a valid entry date.
     */
    @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    /**
     * Tests the constructor with an invalid entry date format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; 
        new DisasterVictim("Freda", invalidEntryDate);
    }

    /**
     * Tests setting the date of birth with a valid format.
     */
    @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    /**
     * Tests setting the date of birth with an invalid format.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); 
    }

    /**
     * Tests setting and getting the first name.
     */
    @Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    /**
     * Tests setting and getting the last name.
     */
    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    /**
     * Tests getting the comments.
     */
    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    /**
     * Tests setting the comments.
     */
    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    /**
     * Tests getting the assigned social ID.
     */
    @Test
    public void testGetAssignedSocialID() {
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");
        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    /**
     * Tests getting the entry date.
     */
    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }

    /**
     * Tests setting and getting the gender.
     */
    @Test
    public void testSetAndGetGender() {
        String newGender = "boy ";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }

    /**
     * Tests setting an invalid gender.
     */
    @Test
    public void testSetInvalidGender() {
        String newGender = "plant";
        try {
            victim.setGender(newGender);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

    /**
     * Tests adding a family connection.
     */
    @Test
    public void testAddFamilyConnection() {
        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        victim2.addFamilyConnection(relation);
        Set<FamilyRelation> testFamily = victim2.getFamilyConnections();
        assertTrue("addFamilyConnection should add a family relationship", testFamily != null && testFamily.contains(relation));
    }

    /**
     * Tests setting a family connection.
     */
    @Test
    public void testSetFamilyConnection() {
        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        Set<FamilyRelation> expectedRelations = new HashSet<>();
        expectedRelations.add(relation);
    
        victim1.addFamilyConnection(relation);
    
        Set<FamilyRelation> actualRecords = victim1.getFamilyConnections();
        assertTrue("Family relation should be set", expectedRelations.size() == actualRecords.size() && expectedRelations.containsAll(actualRecords));
    }

    /**
     * Tests setting medical records.
     */
    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");

        Vector<MedicalRecord> newRecords = new Vector<>();
        newRecords.add(testRecord);
        victim.setMedicalRecords(newRecords);
        Vector<MedicalRecord> actualRecords = victim.getMedicalRecords();

        assertTrue("setMedicalRecords should correctly update medical records",
                newRecords.size() == actualRecords.size() && newRecords.containsAll(actualRecords));
    }

    /**
     * Tests adding medical records.
     */
    @Test
    public void testAddMedicalRecords() {
        Location testLocation = new Location("Shelter A", "4321 Shelter Ave");
        MedicalRecord newRecord = new MedicalRecord(testLocation, "test for covid", "2024-01-09");

        Vector<MedicalRecord> originalRecords = new Vector<>(victim.getMedicalRecords());
        victim.addMedicalRecord(newRecord);
        Vector<MedicalRecord> updatedRecords = new Vector<>(victim.getMedicalRecords());

        assertTrue("addMedicalRecords should add the record to medical records",
                updatedRecords.size() == originalRecords.size() + 1 && updatedRecords.contains(newRecord));
    }    
}
