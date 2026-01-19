package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilitis.DriverUtil;

public class Hooks {
    @Before
    public void setUp() {
        DriverUtil.initDriver();
    }

    @After
    public void tearDown() {
        DriverUtil.quitDriver();
    }
}
