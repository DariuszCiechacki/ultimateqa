package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.simpleelementspage.SimpleElementsPage.simpleElementsPageTitle;

public class VerifyRadiobuttonSelectionTest extends TestCase {

    @Test
    public void verifyRadiobuttonSelectionTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleHtmlElementsPage = homePage.navigateSimpleElementsPage();

        simpleHtmlElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
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
