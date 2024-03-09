package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.ButtonSuccessPage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;

import static drivers.Driver.driver;

public class VerifyNavigationButtonsTest extends TestCase {

    @Test
    public void verifyNavigationButtonsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.byIdButton.click();

        ButtonSuccessPage buttonSuccessPage = new ButtonSuccessPage();

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("By ID button was not clicked correctly",
                buttonSuccessPage.buttonSuccessPageTitleElement.isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.byLinkTextButton.click();

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("By link text button was not clicked correctly",
                buttonSuccessPage.buttonSuccessPageTitleElement.isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.byClassNameButton.click();

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("By class name button was not clicked correctly",
                buttonSuccessPage.buttonSuccessPageTitleElement.isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.byNameButton.click();

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("By name button was not clicked correctly",
                buttonSuccessPage.buttonSuccessPageTitleElement.isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        simpleElementsPage.byClickableIcon.click();

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("By clickable icon button was not clicked correctly",
                buttonSuccessPage.buttonSuccessPageTitleElement.isDisplayed());
    }
}