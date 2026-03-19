package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthentication {
    
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button.radius");

    public FormAuthentication(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureArea clickLoginButton() {
        driver.findElement(loginButton).click();
        return new SecureArea(driver);
    }

    public SecureArea login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }
}
