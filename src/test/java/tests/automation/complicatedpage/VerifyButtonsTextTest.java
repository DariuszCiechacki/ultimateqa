package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyButtonsTextTest extends TestCase {
    protected String expectedButtonsText = "Button";

    @Test
    public void verifyButtonsTextTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();
        complicatedPage.waitForComplicatedPageContent();

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
