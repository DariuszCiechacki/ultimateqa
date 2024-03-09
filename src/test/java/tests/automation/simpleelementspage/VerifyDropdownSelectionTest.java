package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;

public class VerifyDropdownSelectionTest extends TestCase {
    protected String selectOptionValue = "Volvo";

    @Test
    public void verifyDropdownSelectionTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.selectElement.selectByVisibleText(selectOptionValue);

        Assert.assertEquals("Incorrect dropdown selection",
                selectOptionValue, simpleElementsPage.selectElement
                        .getFirstSelectedOption().getText());
    }
}
