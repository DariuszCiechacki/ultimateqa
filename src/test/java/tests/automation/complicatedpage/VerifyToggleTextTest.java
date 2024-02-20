package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.ComplicatedPage.complicatedPageTitle;

public class VerifyToggleTextTest extends TestCase {
    protected final String expectedToggleText = "Inside of toggle";

    @Test
    public void verifyToggleTextTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                driver.findElement(By.xpath(complicatedPageTitle))
                        .isDisplayed());

        complicatedPage.expandToggle();

        Assert.assertEquals("Incorrect inside toggle text",
                expectedToggleText, complicatedPage.getToggleText());
    }
}
