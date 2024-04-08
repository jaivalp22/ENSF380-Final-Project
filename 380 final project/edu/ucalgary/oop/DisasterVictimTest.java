/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/


package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private HashSet<Supply> suppliesToSet;
    private HashSet<FamilyRelation> familyRelations; 
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";
    enum DietMealTypes{
        AVML,
        DBML,
        GFML,
        KSML,
        LSML,
        MOML,
        PFML,
        VGML,
        VJML

    }

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        
    }

  @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; 
        new DisasterVictim("Freda", invalidEntryDate);

    }

   @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); 
    }
	
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    @Test
    public void testGetAssignedSocialID() {

        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Adeleke", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "male";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender", newGender.toLowerCase(), victim.getGender());
    }

    @Test
    public void testSetInvalidGender() {
        String newGender = "plant";
        victim.setGender(newGender);
    }
	
    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);

        Set<FamilyRelation> expectedRelations = new Set<>();
        expectedRelations.add(relation);
        victim2.setFamilyConnections(expectedRelations);
        Set<FamilyRelation> testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily!=null) && (testFamily[0] == expectedRelations[0])) {
                correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        Set<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = testSupplies != null && testSupplies.contains(newSupply);
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

    @Test
    public void testRemoveFamilyConnection() {
            DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
            FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
            FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
            Set<FamilyRelation> expectedRelations = {relation2};
            Set<FamilyRelation> originalRelations = new HashSet<>();
            originalRelations.add(relation1);
            originalRelations.add(relation2);
            
            victim.setFamilyConnections(originalRelations);

            DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
            victim.addFamilyConnection(relation1);
            victim.addFamilyConnection(relation2);
            victim.removeFamilyConnection(relation1);

            Set<FamilyRelation> testFamily = victim.getFamilyConnections();

            assertTrue("removeFamilyConnection should remove the family member",
            testFamily == null || !testFamily.contains(relation1));
    
    }  

    @Test
    public void testRemovePersonalBelonging() {
        
            Supply supplyToRemove = suppliesToSet.get(0); 
            victim.addPersonalBelonging(supplyToRemove); 
            victim.removePersonalBelonging(supplyToRemove);

            Set<Supply> testSupplies = victim.getPersonalBelongings();

            assertTrue("removePersonalBelonging should remove the supply from personal belongings", 
            testSupplies == null || !testSupplies.contains(supplyToRemove));
    
    }

    @Test
        public void testSetFamilyConnection() {
            DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
            DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

            FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
            Set<FamilyRelation> expectedRelations = new HashSet<>();
            expectedRelations.add(relation);
            victim1.setFamilyConnections(expectedRelations);
            

        Set<FamilyRelation> actualRecords = new HashSet<>(Array.asList(victim1.getFamilyConnections()));
        boolean correct = expectedRelations.size() == actualRecords.size() && expectedRelations.containsAll(actualRecords);
        assertTrue("Family relation should be set", correct);
        }

    @Test
    public void testSetMedicalRecords() {
        Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
        MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");

        Vector<MedicalRecord> newRecords = new Vector<>();
        newRecords.add(testRecord);
        victim.setMedicalRecords(newRecords);
        Vector<MedicalRecord> actualRecords = victim.getMedicalRecords();

        boolean correct = newRecords.size() == actualRecords.size() && newRecords.containsAll(actualRecords);
        assertTrue("setMedicalRecords should correctly update medical records", correct);
    }

    @Test
    public void testSetPersonalBelongings() {
        Supply one = new Supply("Tent", 1);
        Supply two = new Supply("Jug", 3);
        Set<Supply> newSupplies = new HashSet<>();
        newSupplies.add(one);
        newSupplies.add(two);


        victim.setPersonalBelongings(newSupplies);
        Set<Supply> actualSupplies = victim.getPersonalBelongings();

        boolean correct = newSupplies.size() == actualSupplies.size() && newSupplies.containsAll(actualSupplies);
        assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
    }

    @Test
    public void testIsValidDateFormat() {
        String invalidDate = "2027-31-21";
        assertThrows(IllegalArgumentException.class, () -> isValidDateFormat(invalidDate));
    }

    @Test
    public void testAddMedicalRecords() {
        Location testLocation = new Location("Shelter A", "4321 Shelter Ave");
        MedicalRecord newRecord = new MedicalRecord(testLocation, "test for covid", "2024-01-09");
        
        Vector<MedicalRecord> originalRecords = new Vector<>(victim.getMedicalRecords());
        victim.addMedicalRecords(newRecord);
        Vector<MedicalRecord> updatedRecords = new Vector<>(victim.getMedicalRecords());

        boolean correct = updatedRecords.size() == originalRecords.size() + 1 && updatedRecords.contains(newRecord);

        assertTrue("addMedicalRecords should add the record to medical records", correct);
    }

    @Test
    public void testSetAndGetDietaryRestrictions() {
        DietMealTypes[] givenDietaryRestrictions = {DietMealTypes.AVML, DietMealTypes.DBML};
        victim.setDietaryRestrictions(givenDietaryRestrictions);
        DietMealTypes[] testDietaryRestrictions = victim.getDietaryRestrictionsAsEnum();
        assertArrayEquals("Dietary restrictions should be set and retrieved correctly", givenDietaryRestrictions, testDietaryRestrictions);
    }
    
    }