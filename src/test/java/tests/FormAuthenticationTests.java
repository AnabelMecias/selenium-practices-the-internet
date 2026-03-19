package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormAuthentication;

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

    formAuthentication.enterUsername(validUsername); // Enter valid username
    formAuthentication.enterPassword(validPassword); // Enter valid password
    formAuthentication.clickLoginButton(); // Click the "Login" button

    }
}
