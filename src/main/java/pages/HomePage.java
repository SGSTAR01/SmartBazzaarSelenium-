package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitis.WaitUtil;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='brave_popup__close__button']")
    private WebElement popUp;

    @FindBy(xpath = "//input[@name='s']")
    private WebElement searchBox;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void closePopUp() {
        WaitUtil.waitForClickable(popUp);
        popUp.click();
    }

    public void searchFor(String item) {
        WaitUtil.waitForVisible(searchBox);
        searchBox.sendKeys(item, Keys.ENTER);
    }
}
