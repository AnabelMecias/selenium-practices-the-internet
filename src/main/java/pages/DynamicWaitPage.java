package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWaitPage {
    private WebDriver driver;

    private By startButton = By.cssSelector("div button");
    private By label = By.cssSelector("#finish h4");

    public DynamicWaitPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(label));
    }   

    public String getLabelText() {
        return driver.findElement(label).getText();
    }
}
