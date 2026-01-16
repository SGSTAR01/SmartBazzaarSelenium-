package tests.dataprovider;

import org.testng.annotations.DataProvider;
import utilitis.ExcelReader;

public class SearchDataProvider {
    @DataProvider(name = "productData")
    public static Object[][] productData() {
        return ExcelReader.getData("src/test/resources/testData/SearchData.xlsx","Products");
    }
}
