package edu.ucalgary.oop;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    private Location location;
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

    /**
     * Generates a unique social ID.
     * @return The generated social ID.
     */
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
    // needed for main file
    public DisasterVictim(String firstName,String lastname, String ENTRY_DATE) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name is empty");
        }
        this.firstName = firstName;
        this.lastName = lastname;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }
    // needed for main file
    public DisasterVictim(String firstName,String lastname,String dateOfBirth, String ENTRY_DATE) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name is empty");
        }
        this.firstName = firstName;
        this.lastName = lastname;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.dateOfBirth = dateOfBirth;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    /**
     * Checks if the given date has a valid format.
     * @param date The date to be checked.
     * @return True if the date has a valid format, false otherwise.
     */
    public static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

    /**
     * Gets the first name of the victim.
     * @return The first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of the victim.
     * @return The last name.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the date of birth of the victim.
     * @return The date of birth.
     */
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Gets the age of the victim.
     * @return The age.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the assigned social ID of the victim.
     * @return The assigned social ID.
     */
    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }

    /**
     * Gets the family connections of the victim.
     * @return The family connections.
     */
    public HashSet<FamilyRelation> getFamilyConnections() {
        return this.familyConnections;
    }

    /**
     * Gets the medical records of the victim.
     * @return The medical records.
     */
    public Vector<MedicalRecord> getMedicalRecords() {
        return this.medicalRecords;
    }

    /**
     * Gets the personal belongings of the victim.
     * @return The personal belongings.
     */
    public HashSet<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }

    /**
     * Gets the entry date of the victim.
     * @return The entry date.
     */
    public String getEntryDate() {
        return this.ENTRY_DATE;
    }

    /**
     * Gets the comments about the victim.
     * @return The comments.
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * Gets the gender of the victim.
     * @return The gender.
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Gets the list of gender options.
     * @return The list of gender options.
     */
    public static List<String> getGenderOptions() {
        if (genderoptions == null) {
            genderoptions = GenderOptionsfiles();
        }
        return genderoptions;
    }

    /**
     * Sets the first name of the victim.
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the victim.
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the age of the victim.
     * @param age The new age.
     */
    public void setAge(Integer age) {
        if (dateOfBirth != null) {
            throw new IllegalStateException("Both age and date of birth cannot be set simultaneously.");
        }
        this.age = age;
        this.dateOfBirth = null;
    }

    /**
     * Sets the date of birth of the victim.
     * @param dateOfBirth The new date of birth in the format "YYYY-MM-DD".
     */
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

    /**
     * Sets the family connections of the victim.
     * @param connections The new family connections.
     */
    public void setFamilyConnections(HashSet<FamilyRelation> connections) {
        this.familyConnections.clear();
        for (FamilyRelation newRecord : connections) {
            addFamilyConnection(newRecord);
        }
    }

    /**
     * Sets the medical records of the victim.
     * @param medicalRecord The new medical records.
     */
    public void setMedicalRecords(Vector<MedicalRecord> medicalRecord) {
        if (!this.medicalRecords.isEmpty()) {
            this.medicalRecords.clear();
        }
        this.medicalRecords = medicalRecord;
    }

    /**
     * Sets the personal belongings of the victim.
     * @param newSupplies The new personal belongings.
     */
    public void setPersonalBelongings(Set<Supply> newSupplies) {
        if (!this.personalBelongings.isEmpty()) {
            this.personalBelongings.clear();
        }
        personalBelongings.forEach(this::addPersonalBelonging);
    }

    /**
     * Sets the comments about the victim.
     * @param comments The new comments.
     */
    public void setComments(String comments) {
        this.comments =  comments;
    }

    /**
     * Sets the gender of the victim.
     * @param gender The new gender.
     */
    public void setGender(String gender) {
        boolean isValidGender = false;
        for (String option : genderoptions) {
            if (option.equalsIgnoreCase(gender)) {
                isValidGender = true;
                break;
            }
        }
        if (!isValidGender) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: " + this.genderoptions);
        }
        this.gender = gender.toLowerCase();
    }

    /**
     * Retrieves gender options from a file.
     * @return The list of gender options.
     */
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

    /**
     * Sets the location of the victim.
     * @param resLocation The location of the victim.
     */
    public void setVictimLocation(Location resLocation){
		this.location = resLocation;
	}

    /**
     * Gets the location of the victim.
     * @param resLocation The location of the victim.
     * @return The location of the victim.
     */
	public Location getVictimLocation(Location resLocation){
		return this.location;
	}
   
    /**
     * Adds a personal belonging to the victim.
     * @param supply The personal belonging to be added.
     */
    public void addPersonalBelonging(Supply supply) {
        boolean atLocation = false;
        for (Supply records : location.getSupplies()) {
            if (records.getType().equals(supply.getType()) && records.getQuantity() >= supply.getQuantity()) {
                records.setQuantity(records.getQuantity() - supply.getQuantity());
                atLocation = true;
                break;
            }
        }
        if (atLocation) {
            boolean inBelongings = false;
    
            for (Supply temp : personalBelongings) {
                if (temp.getType().equals(supply.getType())) {
                    temp.setQuantity(temp.getQuantity() + supply.getQuantity());
                    inBelongings = true;
                    break;
                }
            }
            if (!inBelongings) {
                personalBelongings.add(supply);
            }
        } else {
            throw new IllegalArgumentException("There are not enough supplies at victim's location to give out.");
        }
    }
    
    /**
     * Removes a personal belonging from the victim.
     * @param unwantedSupply The personal belonging to be removed.
     */
    public void removePersonalBelonging(Supply unwantedSupply) {
        boolean supplyRemoved = false;
        int removedQuantity = 0;
    
        for (Supply supply : personalBelongings) {
            if (supply.getType().equals(unwantedSupply.getType())) {
                int availableQuantity = supply.getQuantity();
                if (availableQuantity >= unwantedSupply.getQuantity()) {
                    supply.setQuantity(availableQuantity - unwantedSupply.getQuantity());
                    removedQuantity = unwantedSupply.getQuantity();
                    supplyRemoved = true;
                    if (availableQuantity == unwantedSupply.getQuantity()) {
                        personalBelongings.remove(supply);
                    }
                } else {
                    throw new IllegalArgumentException("Not enough quantity of the supply to remove.");
                }
                break;
            }
        }
    
        if (supplyRemoved) {
            boolean atLocation = false;
            for (Supply temp : location.getSupplies()) {
                if (temp.getType().equals(unwantedSupply.getType())) {
                    temp.setQuantity(temp.getQuantity() + removedQuantity);
                    atLocation = true;
                    break;
                }
            }
            if (!atLocation) {
                location.addSupply(new Supply(unwantedSupply.getType(), removedQuantity));
            }
        } else {
            throw new IllegalArgumentException("The supply you want to remove is not in this person's belongings");
        }
    }
    
    /**
     * Adds a family connection to the victim.
     * @param familyRelation The family connection to be added.
     */
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
            personOne.getFamilyConnections().add(familyRelation);
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
            personTwo.getFamilyConnections().add(inverseRelation);
        }
    }
    
    /**
     * Removes a family connection from the victim.
     * @param exRelation The family connection to be removed.
     */
    public void removeFamilyConnection(FamilyRelation exRelation) {
        DisasterVictim personOne = exRelation.getPersonOne();
        DisasterVictim personTwo = exRelation.getPersonTwo();
        FamilyRelation inverseRelation = relation(exRelation);
    
        boolean exists = false;
        for (FamilyRelation relation : personOne.getFamilyConnections()) {
            if (relation.equals(exRelation)) {
                exists = true;
                break;
            }
        }
    
        if (!exists) {
            throw new IllegalArgumentException("The specified family connection does not exist.");
        }
    
        exists = false;
        for (FamilyRelation relation : personTwo.getFamilyConnections()) {
            if (relation.equals(inverseRelation)) {
                exists = true;
                break;
            }
        }
    
        if (!exists) {
            throw new IllegalArgumentException("The specified family connection does not exist.");
        }
    
        personOne.getFamilyConnections().remove(exRelation);
        personTwo.getFamilyConnections().remove(inverseRelation);
    }
    
    /**
     * Retrieves the inverse relationship of the given family relation.
     * @param relation The family relation.
     * @return The inverse family relation.
     */
    public FamilyRelation relation(FamilyRelation relation) {
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
    
    /**
     * Adds a medical record to the victim.
     * @param record The medical record to be added.
     */
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }
    /**
     * Describes the dietary restrictions of the victim.
     */
    public void RestrictionDesc(){
		for (String restriction : this.DietRestrictions) {
            Meals(DietMealTypes.valueOf(restriction));
        }
	}
    /**
     * Gets the dietary restrictions of the victim.
     * @return The dietary restrictions.
     */
	public String[] getDietaryRestrictions() {
		return this.DietRestrictions;
	}

    /**
     * Sets the dietary restrictions of the victim.
     * @param Restrictions The dietary restrictions to be set.
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
    /**
     * Describes the meals based on the meal types.
     * @param Mplan The meal type.
     */
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
