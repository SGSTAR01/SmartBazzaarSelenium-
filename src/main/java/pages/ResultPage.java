package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitis.ScrollUtil;
import utilitis.WaitUtil;

import java.util.List;

public class ResultPage extends BasePage {

    private final WebDriver driver;

//    @FindBy(xpath = "//main[@id='main']/ul/li")
    private By productItems = By.xpath("//main[@id='main']/ul/li");
    private By productName = By.tagName("h2");


    public ResultPage() {
        this.driver = BasePage.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void selectProduct(String expectedName) {
        try {
            WaitUtil.waitForPresence(productItems);
            List<WebElement> items = driver.findElements(productItems);
            for (WebElement item : items) {
                WebElement nameElement = item.findElement(productName);
                WaitUtil.waitForVisible(nameElement);
                String actualName = nameElement.getText().trim();
                if (actualName.equalsIgnoreCase(expectedName)) {
                    ScrollUtil.scrollToElement(item);
                    WaitUtil.waitForClickable(item);
                    item.click();
                    return;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Product not found :" +expectedName);
        }
    }
}

