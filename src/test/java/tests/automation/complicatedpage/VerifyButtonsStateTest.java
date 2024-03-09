package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;

public class VerifyButtonsStateTest extends TestCase {
    protected final int expectedNumberOfButtons = 12;

    @Test
    public void verifyButtonsStateTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                complicatedPage.complicatedPageTitleElement.isDisplayed());

        Assert.assertEquals("Incorrect number of buttons", expectedNumberOfButtons,
                complicatedPage.buttonElement.size());

        Assert.assertTrue("Buttons are not enabled",
                complicatedPage.verifyButtonsState());
    }
}
