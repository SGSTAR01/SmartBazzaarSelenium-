package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultPage;
import tests.dataprovider.SearchDataProvider;

public class GetProductPriceTest extends BaseTest{
    @Test(dataProvider = "productData" , dataProviderClass = SearchDataProvider.class)
    public void searchProductAndPrintPrice(String searchKey , String productName, String expectedPrice) {
        HomePage homePage = new HomePage();
        ResultPage resultPage = new ResultPage();
        ProductPage productPage = new ProductPage();

        homePage.openSite("https://www.smartbazaar.co.uk/");
        homePage.closePopUp();
        homePage.searchFor(searchKey);

        resultPage.selectProduct(productName);

        String price = productPage.getProductPrice();
        Assert.assertEquals(price,expectedPrice);
    }
}
