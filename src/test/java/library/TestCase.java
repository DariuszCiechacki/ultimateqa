package library;

import com.ultimateqa.config.ConfigLoader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import static library.Driver.driver;

public class TestCase {

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1700, 1080));
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}