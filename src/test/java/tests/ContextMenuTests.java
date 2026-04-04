package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContextManuPage;

public class ContextMenuTests extends BaseTest {

    private ContextManuPage contextMenu;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/context_menu"); // Navigate to the Context Menu page
        contextMenu = new ContextManuPage(driver); // Initialize the page object for Context Menu page
    }

    @Test
    public void testContextMenu() {
        contextMenu.rightClickOnContextMenuArea(); // Perform right-click on the context menu area
        String alertText = contextMenu.JSAlertGetText(); // Get the text of the alert
        contextMenu.JSAletAccept(); // Accept the alert that appears after right-clicking
        System.out.println("Alert text: " + alertText); // Print the alert text to the console
        Assert.assertEquals(alertText, "You selected a context menu", "Alert text does not match expected value after right-clicking on context menu area"); // Assert that the alert text matches the expected value   

    }
}