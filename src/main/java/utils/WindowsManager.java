package utils;

import org.openqa.selenium.WebDriver;

public class WindowsManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowsManager(WebDriver driver) {
        this.driver = driver;
        this.navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public void switchToTab(String tabTitle) {
        var tabs = driver.getWindowHandles();
        System.out.println("Number of tabs: " + tabs.size());

        System.out.println("Window handles:");
        tabs.forEach(System.out::println);

        for (String window : tabs) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }
}
