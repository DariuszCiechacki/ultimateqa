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
    protected String selectOptionValue = "Volvo";

    @Test
    public void verifyDropdownSelectionTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        simpleElementsPage.selectDropdownOption(selectOptionValue);

        Assert.assertEquals("Incorrect dropdown selection",
                selectOptionValue, simpleElementsPage.getSelectedOption());
    }
}
