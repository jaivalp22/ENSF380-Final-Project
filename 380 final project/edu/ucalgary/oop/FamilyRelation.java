package edu.ucalgary.oop;

public class FamilyRelation {
    private DisasterVictim personOne;
    private DisasterVictim personTwo;
    private String relationshipTo;

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    /**
     * Retrieves the first disaster victim.
     * @return The first disaster victim.
     */
    public DisasterVictim getPersonOne() {
        return personOne;
    }

    /**
     * Retrieves the second disaster victim.
     * @return The second disaster victim.
     */
    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    /**
     * Retrieves the relationship between the two disaster victims.
     * @return The relationship between the two disaster victims.
     */
    public String getRelationshipTo() {
        return relationshipTo;
    }

    /**
     * Sets the first disaster victim.
     * @param personOne The first disaster victim.
     */
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    /**
     * Sets the second disaster victim.
     * @param personTwo The second disaster victim.
     */
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }

    /**
     * Sets the relationship between the two disaster victims.
     * @param relationshipTo The relationship between the two disaster victims.
     */
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }
}
