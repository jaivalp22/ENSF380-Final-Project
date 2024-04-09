/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.4
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
    
    public void setPersonalBelongings(Supply[] updatedBelongings) {
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
        boolean atLocation = false;
    
        for (Supply temp : location.getSupplies()) {
            if (temp.getType() == supply.getType() && temp.getQuantity() >= supply.getQuantity()) {
                temp.removeQuantity(supply.getQuantity());
                atLocation = true;
                break;
            }
        }
    
        if (atLocation) {
            boolean inBelongings = false;

            for (Supply temp : personalBelongings) {
                if (temp.getType() == supply.getType()) {
                    temp.addQuantity(supply.getQuantity());
                    inBelongings = true;
                    break;
                }
            }
    
            if (!inBelongings) {
                Supply[] updatedBelongings = Arrays.copyOf(personalBelongings, personalBelongings.length + 1);
                updatedBelongings[personalBelongings.length] = supply;
                this.setPersonalBelongings(updatedBelongings);
            }
        } else {
            throw new IllegalArgumentException("There are not enough supplies at victim's location to give out.");
        }
    }
    
    public void removePersonalBelonging(Supply unwantedSupply) {
        boolean supplyRemoved = false;
        boolean supplyUpdated = false;
        int removedQuantity = 0;
    
        for (int i = 0; i < personalBelongings.length; i++) {
            if (personalBelongings[i].getType() == unwantedSupply.getType()) {
                int availableQuantity = personalBelongings[i].getQuantity();
                if (availableQuantity >= unwantedSupply.getQuantity()) {
                    personalBelongings[i].removeQuantity(unwantedSupply.getQuantity());
                    removedQuantity = unwantedSupply.getQuantity();
                    supplyRemoved = true;
                    if (availableQuantity == unwantedSupply.getQuantity()) {
                        personalBelongings[i] = null;
                    }
                } else {
                    throw new IllegalArgumentException("Not enough quantity of the supply to remove.");
                }
                break;
            }
        }
    
        if (supplyRemoved) {
            victimLocation.addSupply(unwantedSupply.getType(), removedQuantity);
        }
    
        if (!supplyRemoved) {
            if (!victimLocation.hasSupply(unwantedSupply.getType())) {
                victimLocation.addSupply(unwantedSupply);
            }
        }
    
        if (!supplyRemoved && !supplyUpdated) {
            throw new IllegalArgumentException("The supply you want to remove is not in this person's belongings");
        }
    }
    
    public void addFamilyConnection(FamilyRelation familyRelation) {

        DisasterVictim personOne = familyRelation.getPersonOne();
        DisasterVictim personTwo = familyRelation.getPersonTwo();
    
        boolean exists = false;
        for (FamilyRelation relation : personOne.getFamilyConnections()) {
            if (relation.getPersonTwo().equals(personTwo)) {
                exists = true;
                break;
            }
        }
    
        if (!exists) {
            personOne.addConnection(familyRelation);
        }
    
        exists = false;
        for (FamilyRelation relation : personTwo.getFamilyConnections()) {
            if (relation.getPersonTwo().equals(personOne)) {
                exists = true;
                break;
            }
        }
    
        if (!exists) {
            FamilyRelation inverseRelation = new FamilyRelation(personTwo, familyRelation.getRelationshipTo(), personOne);
            personTwo.addConnection(inverseRelation);
        }
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        DisasterVictim personOne = exRelation.getPersonOne();
        DisasterVictim personTwo = exRelation.getPersonTwo();
        FamilyRelation inverseRelation = relationFlipper(exRelation);
    
        if (!personOne.containsConnection(exRelation) || !personTwo.containsConnection(inverseRelation)) {
            throw new IllegalArgumentException("The specified family connection does not exist.");
        }
    
        personOne.removeConnection(exRelation);
        personTwo.removeConnection(inverseRelation);
    }
    
    public FamilyRelation relationFlipper(FamilyRelation relation) {
        DisasterVictim personOne = relation.getPersonOne();
        DisasterVictim personTwo = relation.getPersonTwo();
        String relationshipTo = relation.getRelationshipTo();
    
        String inverseRelationship;
        switch (relationshipTo.toLowerCase()) {
            case "parent":
                inverseRelationship = "child";
                break;
            case "child":
                inverseRelationship = "parent";
                break;
            case "sibling":
                inverseRelationship = "sibling";
                break;
            default:
                inverseRelationship = relationshipTo;
                break;
        }
    
        return new FamilyRelation(personTwo, inverseRelationship, personOne);
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
