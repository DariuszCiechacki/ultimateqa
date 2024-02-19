package tests.automation.simplehtmlelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyDropdownTest extends TestCase {
    @Test
    public void verifyDropdownTest() {
        HomePage homePage = new HomePage().waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
                        .isDisplayed());

        simpleHtmlElementsPage.selectDropdownOption("saab");

        Assert.assertEquals("Incorrect dropdown selection",
                "Saab", driver.findElement(By.xpath("//select")).getText());
    }
}
