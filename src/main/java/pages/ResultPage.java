package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitis.ScrollUtil;
import utilitis.WaitUtil;

import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//main[@id='main']/ul/li")
    private List<WebElement> productItems;
    private By productName = By.tagName("h2");


    public ResultPage() {
        PageFactory.initElements(driver,this);
    }

    public void selectProduct(String expectedName) {
        try {
            for (WebElement item : productItems) {
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
            System.out.println("Product not found :" +expectedName);
        }
    }
}

