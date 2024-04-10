package edu.ucalgary.oop;
import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {
    private DisasterVictim personOne = new DisasterVictim("John Johnson", "2024-10-09");
    private DisasterVictim personTwo = new DisasterVictim("James Bond", "2024-12-02");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    /**
     * Constructor test
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
	
    /**
     * set and get test for personone
     */
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("New Person", "2024-03-22");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    /**
     * set and get test for persontwo
     */
    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Another Person", "2024-05-26");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    /**
     * set and geet test for the relationship between the two
     */
    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }
    
}
