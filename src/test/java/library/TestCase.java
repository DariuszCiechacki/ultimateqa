package library;

import com.ultimateqa.config.ConfigLoader;
import drivers.BrowserType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;

import static drivers.Driver.driver;

public class TestCase {

    @BeforeClass
    public static void setUpWebDriver() {
        String browserName = System.getProperty("browser", "CHROME");

        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        driver = browserType.createWebDriver();

        setWindowDimension();
        navigateToBasePageUrl();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private static void setWindowDimension(){
        driver.manage().window().setSize(new Dimension(1700, 1080));
    }

    private static void navigateToBasePageUrl(){
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }
}