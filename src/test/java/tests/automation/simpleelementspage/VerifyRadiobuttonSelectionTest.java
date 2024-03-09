package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;

public class VerifyRadiobuttonSelectionTest extends TestCase {

    @Test
    public void verifyRadiobuttonSelectionTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.setRadiobutton("male");

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
