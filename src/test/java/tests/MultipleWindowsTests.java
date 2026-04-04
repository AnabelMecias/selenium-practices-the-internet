package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.MultipleWindows;

public class MultipleWindowsTests extends BaseTest {

    private MultipleWindows multipleWindows;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/windows"); // Navigate to the Windows page
        multipleWindows = new MultipleWindows(driver); // Initialize the page object for MultipleWindows
    }

    @Test
    public void testMultipleWindows() {
        multipleWindows.clickOnClickHereLink(); // Click the "Click Here" link to open a new window
        getWindowManager().switchToTab("New Window"); // Switch to the new window based on its title
        String pageTitle = driver.getTitle(); // Get the title of the current window
        System.out.println("Page Title: " + pageTitle); // Print the page title to the console
    }
    
}
