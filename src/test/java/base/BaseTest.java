package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// BaseTest class to set up and tear down WebDriver for each test
public class BaseTest {
    protected WebDriver driver; // Protected WebDriver instance for use in test classes
    protected static final String BASE_URL = "https://the-internet.herokuapp.com";

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Quit the WebDriver instance to close the browser after each test
            driver.quit();
        }
    }
}
