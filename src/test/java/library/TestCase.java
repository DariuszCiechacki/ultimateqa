package library;

import com.ultimateqa.config.ConfigLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static library.Driver.driver;

public class TestCase {

    @BeforeClass
    public static void setUp() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().setSize(new Dimension(1700, 1080));
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}