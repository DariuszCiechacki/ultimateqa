package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;

public class VerifyButtonsTextTest extends TestCase {
    protected final int expectedNumberOfButtons = 12;
    protected final String expectedButtonsText = "Button";

    @Test
    public void verifyButtonsTextTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                complicatedPage.complicatedPageTitleElement.isDisplayed());

        Assert.assertEquals("Incorrect number of buttons", expectedNumberOfButtons,
                complicatedPage.buttonElement.size());

        complicatedPage.getButtonsText().forEach(buttonText -> Assert.assertEquals(
                "Button text does not match",
                expectedButtonsText, buttonText));
    }
}
