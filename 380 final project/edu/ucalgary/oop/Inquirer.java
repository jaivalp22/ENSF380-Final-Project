package edu.ucalgary.oop;

import java.util.Arrays;

public class Inquirer {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;
    private String[] logList;
    private int logCount;

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = phone;
        this.INFO = info;
        this.logList = new String[10];
        this.logCount = 0;
    }

    /**
     * Retrieves the first name of the inquirer.
     * @return The first name of the inquirer.
     */
    public String getFirstName() { 
        return this.FIRST_NAME; }

    /**
     * Retrieves the last name of the inquirer.
     * @return The last name of the inquirer.
     */
    public String getLastName() { 
        return this.LAST_NAME; }

    /**
     * Retrieves the phone number of the disaster-related services.
     * @return The phone number of the disaster-related services.
     */
    public String getServicesPhoneNum() { 
        return this.SERVICES_PHONE; }
        
    /**
     * Retrieves additional information about the inquirer.
     * @return Additional information about the inquirer.
     */
    public String getInfo() { 
        return this.INFO; }

    /**
     * Adds a log entry to the list of logs.
     * @param log The log entry to be added.
     */
    public void addtoLogList(String log) {
        if (logCount == logList.length) {
            resizeLogList();
        }
        logList[logCount++] = log;
    }

    /**
     * Resizes the log list array when it becomes full.
     */
    private void resizeLogList() {
        int newSize = logList.length * 2;
        String[] newLogList = new String[newSize];
        System.arraycopy(logList, 0, newLogList, 0, logCount);
        logList = newLogList;
    }

    /**
     * Retrieves the list of log entries.
     * @return The list of log entries.
     */
    public String[] getLogList() {
        return Arrays.copyOf(logList, logCount);
    }
}
