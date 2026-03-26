package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressedPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterKey(String key) {
        WebElement input = driver.findElement(inputField);
        input.sendKeys(key);
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }

}
