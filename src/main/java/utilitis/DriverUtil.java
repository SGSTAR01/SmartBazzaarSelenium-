package utilitis;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {

    public static void initDriver() {
        BasePage.driver = new ChromeDriver();
        BasePage.driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return BasePage.driver;
    }

    public static void quitDriver() {
        if (BasePage.driver != null) {
            BasePage.driver.quit();
        }
    }
}
