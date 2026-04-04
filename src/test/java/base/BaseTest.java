package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.WindowsManager;

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

    public WindowsManager getWindowManager() {
        return new WindowsManager(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            // Quit the WebDriver instance to close the browser after each test
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshot() throws IOException {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        // 📁 Define folder path (SAFE)
        String folderPath = System.getProperty("user.dir") + "\\screenshots";
        new File(folderPath).mkdirs();

        // 🕒 Timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // 🖼️ Correct file path
        String filePath = folderPath + "\\screenshot_" + timestamp + ".png";

        // 📂 Save
        File destination = new File(filePath);
        FileUtils.copyFile(screenshot, destination);

        System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
    }
}
