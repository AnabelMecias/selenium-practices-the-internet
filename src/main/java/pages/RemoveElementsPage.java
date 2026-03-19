package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveElementsPage {
    private WebDriver driver;

    public RemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addElementButton = By.cssSelector("button[onclick='addElement()']");
    private By deleteButtons = By.cssSelector("div#elements button.added-manually");

    public void clickAddElementOnce() {
        driver.findElement(addElementButton).click();
    }

    public void clickAddElementMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            clickAddElementOnce();
        }
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButtons).size();
    }

    public void clickDeleteButtonAtIndex(int index) {
        if (index >= 0 && index < getDeleteButtonsCount()) {
            driver.findElements(deleteButtons).get(index).click();
        }
    }

    public List<WebElement> getDeleteButtons() {
        return driver.findElements(deleteButtons);
    }
    
}
