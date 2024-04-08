/** 
 * @author Jaival Patel <a href="mailto:jaival.patel@ucalgary.ca">
 * jaival.patel@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

package edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;


public class InquirerTest {
    

private String expectedFirstName = "Joseph";
private String expectedLastName = "Bouillon";
private String expectedPhoneNumber = "+1-123-456-7890";
private String expectedMessage = "looking for my family members";
private Inquirer inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);


    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }


    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }
	

    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }
	

    @Test
    public void testGetServicesPhoneNum() {

        assertEquals("getServicesPhoneNum() should return the correct Services Number",expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }
	

    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage,inquirer.getInfo());
    }

    @Test
    public void testgetCallLogs() {

    }

}