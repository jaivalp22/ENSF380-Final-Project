package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>();
    private ArrayList<Supply> supplies = new ArrayList<>();

    /**
     * Constructs a Location object with a specified name and address.
     * @param name The name of the location.
     * @param address The address of the location.
     */
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Retrieves the name of the location.
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the address of the location.
     * @return The address of the location.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves a copy of the list of occupants at the location.
     * @return A copy of the list of occupants.
     */
    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants);
    }

    /**
     * Retrieves a copy of the list of supplies available at the location.
     * @return A copy of the list of supplies.
     */
    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies);
    }

    /**
     * Sets the name of the location.
     * @param name The new name of the location.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the address of the location.
     * @param address The new address of the location.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Adds a disaster victim as an occupant to the location.
     * @param occupant The disaster victim to be added.
     */
    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    /**
     * Adds a supply to the location.
     * @param supply The supply to be added.
     */
    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    /**
     * Removes a disaster victim from the list of occupants at the location.
     * @param occupant The disaster victim to be removed.
     */
    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    /**
     * Removes a supply from the list of supplies available at the location.
     * @param supply The supply to be removed.
     */
    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
}
