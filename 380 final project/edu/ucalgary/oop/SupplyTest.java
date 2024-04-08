/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SupplyTest {
    String Type = "Blanket";
	int Quantity = 5;
    private Supply supply = new Supply(Type, Quantity);

    @Test
    public void testObjectCreation() { 
        assertNotNull(supply);
    }

    @Test
    public void testGetType() {
        assertEquals("getType should return the correct type", Type, supply.getType());
    }

    @Test
    public void testSetType() {
        supply.setType("Food");
        assertEquals("setType should update the type", "Food", supply.getType());
    }

    @Test
    public void testGetQuantity() {
        assertEquals("getQuantity should return the correct quantity", Quantity, supply.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        supply.setQuantity(20);
        assertEquals("setQuantity should update the quantity", 20, supply.getQuantity());
    }
}