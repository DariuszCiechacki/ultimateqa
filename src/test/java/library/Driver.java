package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Driver {
    public static WebDriver driver = null;
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}
