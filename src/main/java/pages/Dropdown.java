package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    
    private WebDriver driver;
    private By dropdownMenu = By.id("dropdown");

    public Dropdown(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(dropdownMenu));
        select.selectByVisibleText(option);
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdownMenu));
        return select.getFirstSelectedOption().getText();
    }
}
