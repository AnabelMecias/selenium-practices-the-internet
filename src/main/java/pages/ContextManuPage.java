package pages;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextManuPage {
    private WebDriver driver;
    private By contextMenuArea = By.id("hot-spot");
    
    public ContextManuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnContextMenuArea() {
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(contextMenuArea)).perform();
    }

    public void JSAletAccept() {
        driver.switchTo().alert().accept();
    }

    public String JSAlertGetText() {
        return driver.switchTo().alert().getText();
    }
}
