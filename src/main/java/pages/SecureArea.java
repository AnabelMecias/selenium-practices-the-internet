package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {
    
    private WebDriver driver;
    private By successMessage = By.cssSelector("#flash");

    public SecureArea(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

}
