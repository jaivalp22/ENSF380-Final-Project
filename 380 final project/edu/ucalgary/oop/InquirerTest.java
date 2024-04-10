package edu.ucalgary.oop;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;

public class InquirerTest {
    private Inquirer inquirer;
    private String expectedFirstName = "John";
    private String expectedLastName = "Bill";
    private String expectedPhoneNumber = "+1-123-576-7980";
    private String expectedMessage = "looking for my family members";
    private String[] expectedLogList = {"Looking for my father", "Looking for my brother"};


    /**
     * set up for object
     */
    @Before
    public void setUp() {
        inquirer = new Inquirer(expectedFirstName, expectedLastName, expectedPhoneNumber, expectedMessage);
    }

    /**
     * test to see if object is created
     */
    @Test
    public void testObjectCreation() {
        assertNotNull(inquirer);
    }


    /**
     * test for get first name
     */
    @Test
    public void testGetFirstName() {
        assertEquals("getFirstName() should return inquirer's first name", expectedFirstName, inquirer.getFirstName());
    }
	

    /**
     * test for get last name
     */
    @Test
    public void testGetLastName() {
        assertEquals("getLastName() should return inquirer's last name", expectedLastName, inquirer.getLastName());
    }
	

    /**
     * test for get service number
     */
    @Test
    public void testGetServicesPhoneNum() {

        assertEquals("getServicesPhoneNum() should return the correct Services Number",expectedPhoneNumber, inquirer.getServicesPhoneNum());
    }
	

    /**
     * test to get info
     */
    @Test
    public void testGetInfo() {
        assertEquals("getInfo() should return the inquirer message", expectedMessage,inquirer.getInfo());
    }

    /**
     * test for add log list
     */
    @Test
    public void testAddtoLogList() {
        inquirer.addtoLogList("Looking for my father");
        inquirer.addtoLogList("Looking for my brother");
        assertArrayEquals("addtoLogList() should add logs to the log list", expectedLogList, inquirer.getLogList());
    }

    
}
