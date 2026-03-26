package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HorizontalSlider;

public class HorizontalSliderTests extends BaseTest {
    private HorizontalSlider horizontalSlider;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/horizontal_slider"); // Navigate to the Horizontal Slider page
        horizontalSlider = new HorizontalSlider(driver); // Initialize the page object for HorizontalSlider page
    }

    @Test
    public void testHorizontalSlider() {
        double targetValue = 4; // Define the target value to set on the slider
        horizontalSlider.setSliderValue(targetValue); // Set the slider to the target value using the page object method
        double actualValue = horizontalSlider.getSliderValue(); // Get the current value of the slider using the page object method
        System.out.println("Target Value: " + targetValue); // Print the target value to the console
        System.out.println("Actual Value: " + actualValue); // Print the actual value to the console
        // Add assertions to verify the expected behavior

        Assert.assertEquals(actualValue, targetValue, 0.1); // Allow a small margin of error (0.1)
    }
}
