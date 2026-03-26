package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    private WebDriver driver;

    private By profile = By.className("figure");
    private By caption = By.className("figcaption");

    public HoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public FigureCaption hoverOverProfile(int index) {
        WebElement profileElement = driver.findElements(profile).get(index);    
        // Implement hover action using Actions class
        Actions actions = new Actions(driver);
        actions.moveToElement(profileElement).perform();
        FigureCaption figureCaption = new FigureCaption(profileElement.findElement(caption));
        return figureCaption;
    }

    public class FigureCaption {
        private WebElement captionElement;
        
        public FigureCaption(WebElement captionElement) {
            this.captionElement = captionElement;
        }

        public String getTitle() {
            return captionElement.findElement(By.tagName("h5")).getText();
        }

        public String getLink() {
            return captionElement.findElement(By.tagName("a")).getAttribute("href");
        }   

        public String getLinkText() {
            return captionElement.findElement(By.tagName("a")).getText();
        }
        
    }

}
