package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.KeyPressedPage;

public class KeyPressedTest extends BaseTest {
    private KeyPressedPage keyPressedPage;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/key_presses"); // Navigate to the Hover page
        keyPressedPage = new KeyPressedPage(driver); // Initialize the page object for KeyPressed page
    }
    
    @Test
    public void testKeyPress() {
        String keyToPress = "A"; // Define the key to press
        keyPressedPage.enterKey(keyToPress); // Enter the key using the page object method
        String resultText = keyPressedPage.getResultText(); // Get the result text using the page object method
        System.out.println("Result Text: " + resultText); // Print the result text to the console
        // Add assertions to verify the expected behavior
        Assert.assertTrue(resultText.contains("You entered: "+keyToPress), "Expected result text not displayed");
    }
}
