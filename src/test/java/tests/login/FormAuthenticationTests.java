package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormAuthentication;
import pages.SecureArea;

public class FormAuthenticationTests extends BaseTest {
    private FormAuthentication formAuthentication;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/login"); // Navigate to the Form Authentication page
        formAuthentication = new FormAuthentication(driver); // Initialize the page object for Form Authentication page
    }

    @Test (priority = 1, description = "Verify that entering valid credentials and clicking the 'Login' button successfully logs the user in and displays a success message")
    public void testValidLogin() {
    String validUsername = "tomsmith"; // Define valid credentials
    String validPassword = "SuperSecretPassword!"; // Define valid credentials

    SecureArea secureArea = formAuthentication.login(validUsername, validPassword); // Perform login action using the page object method
    System.out.println(secureArea.getSuccessMessage()); // Print the success message to the console
    Assert.assertTrue(secureArea.getSuccessMessage().contains("You logged into a secure area!"), "Expected success message not found");

    }
}
