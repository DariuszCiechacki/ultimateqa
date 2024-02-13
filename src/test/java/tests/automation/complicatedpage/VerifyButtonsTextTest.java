package tests.automation.complicatedpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VerifyButtonsTextTest extends TestCase {
    protected String expectedButtonsText = "Button";

    @Test
    public void verifyButtonsTextTest() {
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

        Assert.assertFalse("List of buttons text is empty",
                complicatedPage.getButtonsText().isEmpty());

        complicatedPage.getButtonsText().forEach(buttonText -> Assert.assertEquals(
                "Button text does not match",
                expectedButtonsText, buttonText));
    }
}
