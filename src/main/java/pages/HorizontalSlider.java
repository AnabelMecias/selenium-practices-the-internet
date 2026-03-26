package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSlider {
    private WebDriver driver;
    private By slider = By.tagName("input");
    private By sliderValue = By.id("range");
    
    public HorizontalSlider(WebDriver driver) {
        this.driver = driver;
    }

    public void setSliderValue(double value) {
        // Implementation for setting slider value  
        WebElement  sliderElement = driver.findElement(slider);
        int amountArrowPresses = (int) (value /0.5); // Assuming the slider has a range of 0 to 5 with increments of 0.5
        for (int i = 0; i < amountArrowPresses; i++) {
            sliderElement.sendKeys(String.valueOf(Keys.ARROW_RIGHT));
        }
    }

    public double getSliderValue() {
        return Double.parseDouble(driver.findElement(sliderValue).getText());
    }
    
}
