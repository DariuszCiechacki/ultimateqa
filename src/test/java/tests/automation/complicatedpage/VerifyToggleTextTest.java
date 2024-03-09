package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;

public class VerifyToggleTextTest extends TestCase {
    protected final String expectedToggleText = "Inside of toggle";

    @Test
    public void verifyToggleTextTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                complicatedPage.complicatedPageTitleElement.isDisplayed());

        complicatedPage.expandToggle();

        Assert.assertEquals("Incorrect inside toggle text",
                expectedToggleText, complicatedPage.toggleContentElement.getText());
    }
}
