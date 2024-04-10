package edu.ucalgary.oop;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SupplyTest {
    String Type = "Blanket";
	int Quantity = 6;
    private Supply supply;

    @Before
    public void setUp() {
        supply = new Supply(Type, Quantity); // Initialize instance variable
    }


    /**
     * test for constructor
     */
    @Test
    public void testObjectCreation() { 
        supply = new Supply(Type, Quantity);
        assertNotNull(supply);
    }

    /**
     * test for get type
     */
    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", Type, supply.getType());
    }

    /**
     * test for set type
     */
    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    /**
     * test for get quantity
     */
    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", Quantity, supply.getQuantity());
    }

    /**
     * test for set quantity
     */
    @Test
    public void testSetQuantity() {
        supply.setQuantity(2);
        assertEquals("setQuantity should update the quantity", 2, supply.getQuantity());
    }
    
}
