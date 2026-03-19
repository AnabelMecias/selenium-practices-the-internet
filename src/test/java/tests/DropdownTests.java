package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.Dropdown;

public class DropdownTests extends BaseTest {
    private Dropdown dropdown;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/dropdown"); // Navigate to the Dropdown page
        dropdown = new Dropdown(driver); // Initialize the page object for Dropdown page
    }

    @Test (priority = 1, description = "Verify that selecting an option from the dropdown menu updates the selected option correctly")
    public void testSelectOption() {
        String optionToSelect = "Option 2"; // Define the option to select
        dropdown.selectOption(optionToSelect); // Select the option using the page object method
        String selectedOption = dropdown.getSelectedOption(); // Get the selected option using the page object method
        System.out.println("Selected Option: " + selectedOption); // Print the selected option to the console
        // Add assertions to verify the expected behavior
        Assert.assertTrue(selectedOption.equalsIgnoreCase(optionToSelect), "Expected option not selected");
    }
    
}
