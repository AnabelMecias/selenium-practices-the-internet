package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HoverPage;

public class HoverPageTests extends BaseTest {
    private HoverPage hoverPage;
    
    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/hovers"); // Navigate to the Hover page
        hoverPage = new HoverPage(driver); // Initialize the page object for Hover page
    }

    @Test (priority = 1, description = "Verify that hovering over each profile displays the correct caption and link")
    public void testHoverOverProfiles() {
        for (int i = 0; i < 3; i++) { // There are 3 profiles to hover over
            HoverPage.FigureCaption caption = hoverPage.hoverOverProfile(i); // Hover over the profile and get the caption
            System.out.println("Profile " + (i + 1) + " Title: " + caption.getTitle()); // Print the title of the caption to the console
            System.out.println("Profile " + (i + 1) + " Link: " + caption.getLink()); // Print the link of the caption to the console
            System.out.println("Profile " + (i + 1) + " Link Text: " + caption.getLinkText()); // Print the link text of the caption to the console
            
            Assert.assertEquals(caption.getTitle(), "name: user" + (i + 1), "Caption title does not match expected value for profile " + (i + 1)); // Assert that the caption title matches the expected value
            Assert.assertTrue(caption.getLink().endsWith("/users/" + (i + 1)), "Caption link does not end with expected value for profile " + (i + 1)); // Assert that the caption link ends with the expected value
            Assert.assertEquals(caption.getLinkText(), "View profile", "Caption link text does not match expected value for profile " + (i + 1)); // Assert that the caption link text matches the expected value
        }
    }
}
