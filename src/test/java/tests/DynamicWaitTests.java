package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DynamicWaitPage;

public class DynamicWaitTests extends BaseTest {
    private DynamicWaitPage dynamicWaitPage;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/dynamic_loading/1"); // Navigate to the Dynamic Loading page
        dynamicWaitPage = new DynamicWaitPage(driver); // Initialize the page object for DynamicWaitPage
    }

    @Test
    public void testDynamicWait() {
        dynamicWaitPage.clickStartButton(); // Click the start button to trigger the dynamic loading
        String labelText = dynamicWaitPage.getLabelText(); // Get the text of the label after it becomes visible
        System.out.println("Label Text: " + labelText); // Print the label text to the console
        Assert.assertEquals(labelText, "Hello World!"); // Assert that the label text is as expected
    }
    
}
