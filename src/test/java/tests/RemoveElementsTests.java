
package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.RemoveElementsPage;

import org.testng.Assert;

public class RemoveElementsTests extends BaseTest {
    private RemoveElementsPage removeElementsPage;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/add_remove_elements/"); // Navigate to the Remove Elements page
        removeElementsPage = new RemoveElementsPage(driver); // Initialize the page object for Remove Elements page
    }

    @Test (priority = 1, description = "Verify that clicking the 'Add Element' button once adds one delete button to the page")
    public void testAddOneElement() {
        int initialDeleteButtonsCount = removeElementsPage.getDeleteButtonsCount(); // Get the initial count of delete buttons
        removeElementsPage.clickAddElementOnce(); // Click the "Add Element" button once
        int finalDeleteButtonsCount = removeElementsPage.getDeleteButtonsCount(); // Get the final count of delete buttons
        // Add assertions to verify the expected behavior
        System.out.println("Initial Delete Buttons Count: " + initialDeleteButtonsCount);
        System.out.println("Final Delete Buttons Count: " + finalDeleteButtonsCount);
        Assert.assertEquals(finalDeleteButtonsCount, initialDeleteButtonsCount+1);
    }

    @Test (priority = 2, description = "Verify that clicking the 'Add Element' button multiple times adds the correct number of delete buttons to the page")
    void testAddMultipleElements() {
        int initialDeleteButtonsCount = removeElementsPage.getDeleteButtonsCount(); // Get the initial count of delete buttons
        int timesToAdd = 5; // Define how many times to click the "Add Element" button
        removeElementsPage.clickAddElementMultipleTimes(timesToAdd); // Click the "Add Element" button multiple times
        int finalDeleteButtonsCount = removeElementsPage.getDeleteButtonsCount(); // Get the final count of delete buttons
        System.out.println("Initial Delete Buttons Count: " + initialDeleteButtonsCount);
        System.out.println("Times to Add: " + timesToAdd);
        System.out.println("Final Delete Buttons Count: " + finalDeleteButtonsCount);
        // Add assertions to verify the expected behavior
        Assert.assertEquals(finalDeleteButtonsCount, initialDeleteButtonsCount+timesToAdd);
    }
}