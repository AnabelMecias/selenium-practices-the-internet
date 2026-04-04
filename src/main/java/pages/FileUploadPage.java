package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {
    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    
    public FileUploadPage (WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        WebElement chooseFile = driver.findElement(chooseFileButton);
        chooseFile.sendKeys(filePath);
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFiles).getText();
    }

}
