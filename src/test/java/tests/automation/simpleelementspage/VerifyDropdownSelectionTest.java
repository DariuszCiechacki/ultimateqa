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

public class VerifyDropdownSelectionTest extends TestCase {

    @Test
    public void verifyDropdownSelectionTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleHtmlElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        simpleElementsPage.selectDropdownOption("saab");

        //ToDo find a method for getting selected option value
        /*Assert.assertEquals("Incorrect dropdown selection",
                "Saab", driver.findElement(By.xpath("//select")).getText());*/
    }
}
