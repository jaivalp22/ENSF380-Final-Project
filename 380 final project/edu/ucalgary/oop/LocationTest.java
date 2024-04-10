package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;

public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private DisasterVictim victim1;
    private Supply supply;
    private Supply supply1;
    private String name;
    private String address;


    /**
     * prepars the object
     */
    @Before
    public void setUp() {
        name = "Shelter";
        address = "1234 Ave";
        location = new Location(name, address);
        victim = new DisasterVictim("John Johnson", "2024-04-02");
        victim1 = new DisasterVictim("James Bond", "2022-03-18");
        supply = new Supply("Sheild", 10);
        supply1 = new Supply("Hat", 2);
        HashSet<DisasterVictim> occupants = new HashSet<>();
        HashSet<Supply> supplies = new HashSet<>();
        occupants.add(victim);
        occupants.add(victim1);
        supplies.add(supply);
        supplies.add(supply1);
    }


    /**
     * checks if supply is in list
     */
    private boolean containsSupply(ArrayList<Supply> supplies, Supply supplyToCheck) {
        return supplies.contains(supplyToCheck);
    }

    /**
     * test for constructor
     */
    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Ave", location.getAddress());
    }

    /**
     * test for set name
     */
    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    /**
     * test for set address
     */
    @Test
    public void testSetAddress() {
        String newAddress = "4 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    /**
     * test for add occupant
     */
    @Test
    public void testAddOccupant() {
        DisasterVictim victim2 = new DisasterVictim("Mike Ross", "2022-02-22");
        location.addOccupant(victim2);
        assertTrue("addOccupant should add a disaster victim to the occupants list", location.getOccupants().contains(victim2));
    }

    /**
     * test for remove occupant
     */
    @Test
    public void testRemoveOccupant() {
        DisasterVictim victim3 = new DisasterVictim("Amy Jackson", "2023-12-20");
        location.addOccupant(victim3);
        location.removeOccupant(victim3);
        assertFalse("removeOccupant should remove the disaster victim from the occupants list", location.getOccupants().contains(victim3));
    }

    /**
     * test for set and get occupants
     */
    @Test
    public void testAddAndGetOccupants() {
        DisasterVictim victim4 = new DisasterVictim("Megh Smith", "2020-07-15");
        HashSet<DisasterVictim> newOccupants = new HashSet<>();
        newOccupants.add(victim4);
        location.addOccupant(victim4);
        assertTrue("addOccupant should add the occupant to the location", location.getOccupants().containsAll(newOccupants));
    }

    /**
     * test for add supply
     */
    @Test
    public void testAddSupply() {
        Supply supply2 = new Supply("Shoes", 9);
        location.addSupply(supply2);
        assertTrue("addSupply should add a supply to the supplies list", containsSupply(location.getSupplies(), supply2));
    }

    /**
     * test for remove supply
     */
    @Test
    public void testRemoveSupply() {
        Supply supply3 = new Supply("tape", 5);
        location.addSupply(supply3);
        location.removeSupply(supply3);
        assertFalse("removeSupply should remove the supply from the supplies list", containsSupply(location.getSupplies(), supply3));
    }

    /**
     * test for set and get supply
     */
    @Test
    public void testAddAndGetSupplies() {
        Supply supply4 = new Supply("bottles", 5);
        HashSet<Supply> newSupplies = new HashSet<>();
        newSupplies.add(supply4);
        location.addSupply(supply4);
        assertTrue("addSupply should add the supply to the location", containsSupply(location.getSupplies(), supply4));
    }
    
}
