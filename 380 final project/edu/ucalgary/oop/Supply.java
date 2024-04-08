/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

public class Supply {
    private int quantity;
    private String type;


    public Supply(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() { 
        return this.type; }

    public int getQuantity() { 
        return this.quantity; }

    public void setType(String type) { 
        this.type = type; }

    public void setQuantity(int quantity) { 
        this.quantity = quantity; }

}
