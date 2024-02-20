package tests.automation.simplehtmlelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyRadiobuttonTest extends TestCase {

    @Test
    public void verifyRadiobuttonTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
                        .isDisplayed());

        simpleHtmlElementsPage.setRadiobutton("male");

        Assert.assertTrue("Incorrect radiobutton selection",
                driver.findElement(By.xpath("//input[@type='radio' and @value='male']"))
                        .isSelected());

        Assert.assertFalse("Incorrect radiobutton selection",
                driver.findElement(By.xpath("//input[@type='radio' and @value='female']"))
                        .isSelected());

        Assert.assertFalse("Incorrect radiobutton selection",
                driver.findElement(By.xpath("//input[@type='radio' and @value='other']"))
                        .isSelected());
    }
}
