package edu.ucalgary.oop;

public class Supply {
    private int quantity;
    private String type;

    public Supply(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * Retrieves the type of the supply.
     * @return The type of the supply.
     */
    public String getType() { 
        return this.type; }

    /**
     * Retrieves the quantity of the supply.
     * @return The quantity of the supply.
     */
    public int getQuantity() { 
        return this.quantity; }

    /**
     * Sets the type of the supply.
     * @param type The type of the supply.
     */
    public void setType(String type) { 
        this.type = type; }

    /**
     * Sets the quantity of the supply.
     * @param quantity The quantity of the supply.
     */
    public void setQuantity(int quantity) { 
        this.quantity = quantity; }

}
