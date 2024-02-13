package tests.automation.complicatedpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.modules.automation.complicatedpage.SectionOfButtonsData;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VerifyButtonsStateTest extends TestCase {
    @Test
    public void verifyButtonsStateTest() {
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

        driver.findElements(By.xpath(SectionOfButtonsData.buttonsXpath)).forEach(element -> Assert.assertTrue(
                "Buttons are not enabled", element.isEnabled()));
    }
}