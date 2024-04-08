/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants = new ArrayList<>();
    private ArrayList<Supply> supplies = new ArrayList<>();


    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<DisasterVictim> getOccupants() {
        return new ArrayList<>(occupants);
    }

    public ArrayList<Supply> getSupplies() {
        return new ArrayList<>(supplies);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = new ArrayList<>(occupants);
    }

    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = new ArrayList<>(supplies);
    }

    public void addOccupant(DisasterVictim occupant) {
        occupants.add(occupant);
    }

    public void addSupply(Supply supply) {
        supplies.add(supply);
    }

    public void removeOccupant(DisasterVictim occupant) {
        occupants.remove(occupant);
    }

    public void removeSupply(Supply supply) {
        supplies.remove(supply);
    }
}
