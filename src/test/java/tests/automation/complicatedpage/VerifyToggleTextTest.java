package tests.automation.complicatedpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VerifyToggleTextTest extends TestCase {
    protected String expectedToggleText = "Inside of toggle";

    @Test
    public void verifyToggleTextTest() {
        driver.get(ConfigLoader.getProperty("baseUrl"));

        HomePage homePage = new HomePage(driver).waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();
        complicatedPage.waitForPageContent();

        Assert.assertTrue("Complicated page is not visible",
                driver.findElement(By.id("Skills_Improved"))
                        .isDisplayed());

        Assert.assertEquals("Incorrect inside toggle text",
                expectedToggleText, complicatedPage.getToggleText());
    }
}
