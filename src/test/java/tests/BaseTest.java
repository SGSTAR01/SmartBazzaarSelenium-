package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilitis.DriverUtil;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverUtil.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtil.quitDriver();
    }
}
