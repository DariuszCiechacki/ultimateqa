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

public class VerifyButtonsTextTest extends TestCase {
    protected final int expectedNumberOfButtons = 12;
    protected final String expectedButtonsText = "Button";

    @Test
    public void verifyButtonsTextTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                driver.findElement(By.xpath(complicatedPageTitle))
                        .isDisplayed());

        Assert.assertEquals("Incorrect number of buttons", expectedNumberOfButtons,
                complicatedPage.countButtonsInSectionOfButtons());

        complicatedPage.getButtonsText().forEach(buttonText -> Assert.assertEquals(
                "Button text does not match",
                expectedButtonsText, buttonText));
    }
}
