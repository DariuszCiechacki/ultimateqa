package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserType {
    CHROME {
        public WebDriver createWebDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    },
    EDGE {
        public WebDriver createWebDriver(){
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    },

    FIREFOX {
        public WebDriver createWebDriver(){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver createWebDriver();
}
