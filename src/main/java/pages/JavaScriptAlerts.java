package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlerts {
    private WebDriver driver;
    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public JavaScriptAlerts(WebDriver driver) {
        this.driver = driver;
    }

    public void clickJSAlert() {
        driver.findElement(jsAlertButton).click();
    }

    public void clickJSConfirm() {
        driver.findElement(jsConfirmButton).click();
    }

    public void clickJSPrompt() {
        driver.findElement(jsPromptButton).click();
    }

    public String getResult (){
        return driver.findElement(resultText).getText();
    }

    public void JSAlertAccept() {
        driver.switchTo().alert().accept();
    }

    public void JSAlertDismiss() {
        driver.switchTo().alert().dismiss();
    }   

    public void JSPromptSendText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


}
