package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DynamicWaitPage;

public class NavigationTestTest extends BaseTest {

    private DynamicWaitPage dynamicWaitPage;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/dynamic_loading/1"); // Navigate to the Dynamic Loading page
        dynamicWaitPage = new DynamicWaitPage(driver); // Initialize the page object for DynamicWaitPage
    }
    @Test
    public void testNavigator(){
        dynamicWaitPage.clickStartButton(); // Click the start button to trigger the dynamic loading
        getWindowManager().goBack();
        getWindowManager().goTo("https://google.com");
    }
    
}
