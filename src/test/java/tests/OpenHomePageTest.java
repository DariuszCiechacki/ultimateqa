package tests;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class OpenHomePageTest extends TestCase {

    @Test
    public void openPageTest() {
        driver.get(ConfigLoader.getProperty("baseUrl"));

        new HomePage(driver).waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("menu-main-menu"))
                        .isDisplayed());
    }
}
