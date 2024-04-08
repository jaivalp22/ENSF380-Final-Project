/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.time.LocalDate;


public class DisasterVictim {
    private static int counter = 0;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private final int ASSIGNED_SOCIAL_ID;
    private ArrayList<FamilyRelation> familyConnections = new ArrayList<>();
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private Supply[] personalBelongings;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

  public FamilyRelation[] getFamilyConnections() {
        return familyConnections.toArray(new FamilyRelation[0]);
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords.toArray(new MedicalRecord[0]);
    }

    public Supply[] getPersonalBelongings() {
        return this.personalBelongings;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        if (dateOfBirth != null) {
            throw new IllegalStateException("Both age and date of birth cannot be set simultaneously.");
        }
        this.age = age;
        this.dateOfBirth = null;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (age != 0) {
            throw new IllegalStateException("Both age and date of birth cannot be set simultaneously.");
        }
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
        this.age = 0;
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        this.familyConnections.clear();
        for (FamilyRelation newRecord : connections) {
            addFamilyConnection(newRecord);
        }
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords.clear();
        for (MedicalRecord newRecord : records) {
            addMedicalRecord(newRecord);
        }
    }

    public void setPersonalBelongings(Supply[] belongings) {
        this.personalBelongings = belongings;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public void setGender(String gender) {
        if (!gender.matches("(?i)^(male|female|other)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are male, female, or other.");
        }
        this.gender = gender.toLowerCase();
    }
   
    public void addPersonalBelonging(Supply supply) {

        location.removeSupply(supply);

        if (this.personalBelongings == null) {
            Supply tmpSupply[] = {supply};
            this.setPersonalBelongings(tmpSupply);
            return;
        }

        int newLength = this.personalBelongings.length + 1;
        Supply tmpPersonalBelongings[] = new Supply[newLength];

        int i;
        for (i=0; i < personalBelongings.length; i++) {
            tmpPersonalBelongings[i] = this.personalBelongings[i];
        }

        tmpPersonalBelongings[i] = supply;

        this.personalBelongings = tmpPersonalBelongings;
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        Supply[] updatedBelongings = new Supply[personalBelongings.length-1];
        int index = 0;
        int newIndex = index;
        for (Supply supply : personalBelongings) {
            if (!supply.equals(unwantedSupply)) {
                updatedBelongings[newIndex] = supply;
                newIndex++;
            }
            index++;
        }
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        familyConnections.add(record);
    }

    public void addFamilyConnection(FamilyRelation relationship) {

        DisasterVictim personOne = relationship.getPersonOne();
        DisasterVictim personTwo = relationship.getPersonTwo();
    

        if (personOne.getFamilyConnections().contains(relationship) ||
            personTwo.getFamilyConnections().contains(relationship)) {
            throw new IllegalArgumentException("Duplicate relationship detected.");
        }
    

        personOne.familyConnections.add(relationship);
        personTwo.familyConnections.add(relationship);
    

        for (FamilyRelation existingRelation : personOne.getFamilyConnections()) {
            DisasterVictim otherPersonOne = existingRelation.getPersonOne();
            DisasterVictim otherPersonTwo = existingRelation.getPersonTwo();
            if ((otherPersonOne.equals(personOne) && !otherPersonTwo.equals(personTwo)) ||
                (!otherPersonOne.equals(personOne) && otherPersonTwo.equals(personTwo))) {
                addFamilyConnection(new FamilyRelation(otherPersonOne, personTwo));
                break;
            }
        }
    }
    
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }
}
