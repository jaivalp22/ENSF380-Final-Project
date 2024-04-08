/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

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

    public DisasterVictim getPersonOne() {
        return personOne;
    }

    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    public String getRelationshipTo() {
        return relationshipTo;
    }

    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }

    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }

    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }
}
