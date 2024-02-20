package tests;

import library.TestCase;
import library.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;

public class OpenHomePageTest extends TestCase {

    @Test
    public void openPageTest() {
        new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());
    }
}
