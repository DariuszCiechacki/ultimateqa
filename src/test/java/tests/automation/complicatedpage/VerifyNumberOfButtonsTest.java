package tests.automation.complicatedpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyNumberOfButtonsTest extends TestCase {
    protected int expectedNumberOfButtons = 12;

    @Test
    public void verifyNumberOfButtonsTest() {
        HomePage homePage = new HomePage().waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();
        complicatedPage.waitForPageContent();

        Assert.assertTrue("Complicated page is not visible",
                driver.findElement(By.id("Skills_Improved"))
                        .isDisplayed());

        Assert.assertEquals("Incorrect number of buttons", expectedNumberOfButtons,
                complicatedPage.countButtonsInSectionOfButtons());
    }
}
