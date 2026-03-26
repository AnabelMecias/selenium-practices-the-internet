package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.JavaScriptAlerts;

public class JavaScriptAlertsTests extends BaseTest {
    private JavaScriptAlerts javaScriptAlerts;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/javascript_alerts"); // Navigate to the JavaScript Alerts page
        javaScriptAlerts = new JavaScriptAlerts(driver); // Initialize the page object for JavaScriptAlerts page
    }

    @Test
    public void testJSAlert() {
        javaScriptAlerts.clickJSAlert(); // Click the button to trigger the JS Alert
        javaScriptAlerts.JSAlertAccept(); // Accept the alert
        String result = javaScriptAlerts.getResult(); // Get the result text after accepting the alert
        System.out.println("Result after accepting JS Alert: " + result); // Print the result to the console

        Assert.assertEquals(result, "You successfully clicked an alert", "Result text does not match expected value after accepting JS Alert"); // Assert that the result text matches the expected value
    }

    @Test
    public void testJSConfirmDismiss() {
        javaScriptAlerts.clickJSConfirm(); // Click the button to trigger the JS Confirm
        javaScriptAlerts.JSAlertDismiss(); // Dismiss the confirm alert
        String result = javaScriptAlerts.getResult(); // Get the result text after dismissing the alert
        System.out.println("Result after dismissing JS Confirm: " + result); // Print the result to the console

        Assert.assertEquals(result, "You clicked: Cancel", "Result text does not match expected value after dismissing JS Confirm"); // Assert that the result text matches the expected value
    }

    @Test
    public void testJSConfirmAccept() {
        javaScriptAlerts.clickJSConfirm(); // Click the button to trigger the JS Confirm
        javaScriptAlerts.JSAlertAccept(); // Accept the confirm alert
        String result = javaScriptAlerts.getResult(); // Get the result text after accepting the alert
        System.out.println("Result after accepting JS Confirm: " + result); // Print the result to the console

        Assert.assertEquals(result, "You clicked: Ok", "Result text does not match expected value after accepting JS Confirm"); // Assert that the result text matches the expected value
    }

    @Test
    public void testJSPrompt() {
        String inputText = "Hello World"; // Define the text to be entered in the prompt
        javaScriptAlerts.clickJSPrompt(); // Click the button to trigger the JS Prompt
        javaScriptAlerts.JSPromptSendText(inputText); // Send text to the prompt
        javaScriptAlerts.JSAlertAccept(); // Accept the prompt alert
        String result = javaScriptAlerts.getResult(); // Get the result text after accepting the prompt
        System.out.println("Result after accepting JS Prompt: " + result); // Print the result to the console

        Assert.assertEquals(result, "You entered: " + inputText, "Result text does not match expected value after accepting JS Prompt"); // Assert that the result text matches the expected value
    }
}
