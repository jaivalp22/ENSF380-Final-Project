/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.3
 * @since 1.0
*/

package edu.ucalgary.oop;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;


public class DisasterVictim {
    private static int counter = 0;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private final String ENTRY_DATE;
    private final int ASSIGNED_SOCIAL_ID;
    private HashSet<FamilyRelation> familyConnections = new HashSet<>();
    private Vector<MedicalRecord> medicalRecords = new Vector<>();
    private HashSet<Supply> personalBelongings = new HashSet<>();
    private String gender;
    private static ArrayList<String> genderoptions = GenderOptionsfiles();
    private String comments;
    private String[] DietRestrictions;
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

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is empty");
        }
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
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getAge() {
        return this.age;
    }

    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }

  public HashSet<FamilyRelation> getFamilyConnections() {
        return this.familyConnections;
    }

    public Vector<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }

    public HashSet<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }

    public String getEntryDate() {
        return this.ENTRY_DATE;
    }

    public String getComments() {
        return this.comments;
    }

    public String getGender() {
        return this.gender;
    }

    public static List<String> getGenderOptions() {
        if (genderoptions == null) {
            genderoptions = GenderOptionsfiles();
        }
        return genderoptions;
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

    public void setFamilyConnections(HashSet<FamilyRelation> connections) {
        this.familyConnections.clear();
        for (FamilyRelation newRecord : connections) {
            addFamilyConnection(newRecord);
        }
    }

    public void setMedicalRecords(Vector<MedicalRecord> medicalRecord) {
        if (!this.medicalRecords.isEmpty()) {
            this.medicalRecords.clear();
        }
        this.medicalRecords = medicalRecord;
    }
    
    public void setPersonalBelongings(HashSet<Supply> belongings) {
        if (!this.personalBelongings.isEmpty()) {
            this.personalBelongings.clear();
        }
        personalBelongings.forEach(this::addPersonalBelonging);
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public void setGender(String gender) {
        if (!genderoptions.contains(gender.toLowerCase())) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: " + this.genderoptions);
        }
        this.gender = gender.toLowerCase();
    }
    

    public static ArrayList<String> GenderOptionsfiles() {
        ArrayList<String> options = new ArrayList<>();
        String filename = "edu/ucalgary/oop/GenderOptions.txt";
        try (Scanner scan = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scan.hasNextLine()) {
                options.add(scan.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error reading gender options from file: " + e.getMessage());
            e.printStackTrace();
        }
        return options;
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

    public void RestrictionDesc(){
		for (String restriction : this.DietRestrictions) {
            Meals(DietMealTypes.valueOf(restriction));
        }
	}

	public String[] getDietaryRestrictions() {
		return this.DietRestrictions;
	}

    /**
     * @param Restrictions
     */
    public void setDietaryRestrictions(String[] Restrictions) {

        Set<DietMealTypes> Meal_Restrictions = new HashSet<>();
        Collections.addAll(Meal_Restrictions, DietMealTypes.values());
        

        for (String restriction : Restrictions) {
            if (!Meal_Restrictions.contains(restriction)) {
                throw new IllegalArgumentException("This dietary restriction does not exist: " + restriction);
            }
        }

        this.DietRestrictions = Restrictions;
    }

    public static void Meals(DietMealTypes Mplan) {     

        switch(Mplan) {
            case AVML:
                System.out.println(Mplan + "Asian vegetarian meal");
                break;
            case DBML:
                System.out.println(Mplan + "Diabetic meal");
                break;
            case GFML: 
                System.out.println(Mplan + "Gluten intolerant meal");
                break;
            case KSML:
                System.out.println(Mplan + "Kosher meal");
                break;
            case LSML:
                System.out.println(Mplan + "Low salt meal");
                break;
            case MOML:
                System.out.println(Mplan + "Muslim meal");
                break;
            case PFML:
                System.out.println(Mplan + "Peanut-free meal");
                break;
            case VGML:
                System.out.println(Mplan + "Vegan meal");
                break;
            case VJML:
                System.out.println(Mplan + "Vegetarian Jain meal");
                break;

        }
    }
}
