package tests.dataprovider;

import org.testng.annotations.DataProvider;
import utilitis.ExcelReader;

public class SearchDataProvider {
    @DataProvider(name = "productData", parallel = true)
    public static Object[][] productData() {
        return ExcelReader.getData("src/test/resources/testdata/SearchData.xlsx","Products");
    }
}
