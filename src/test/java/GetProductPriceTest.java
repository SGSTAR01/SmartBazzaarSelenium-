import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultPage;

public class GetProductPriceTest extends BaseTest{
    @Test
    public void searchProductAndPrintPrice() {
        HomePage homePage = new HomePage();
        ResultPage resultPage = new ResultPage();
        ProductPage productPage = new ProductPage();

        homePage.openSite("https://www.smartbazaar.co.uk/");
        homePage.closePopUp();
        homePage.searchFor("rice");

        resultPage.selectProduct("Shree Krishna Premium Basmati Rice (5kg)");

        String price = productPage.getProductPrice();
        System.out.println("Product Price: " + price);
    }
}
