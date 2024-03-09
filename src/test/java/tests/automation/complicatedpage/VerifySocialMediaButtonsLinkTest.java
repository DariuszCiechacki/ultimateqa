package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class VerifySocialMediaButtonsLinkTest extends TestCase {
    protected final int expectedSocialMediaLinksNumber = 5;
    protected final String expectedTwitterLink = "https://twitter.com/Nikolay_A00";
    protected final String expectedFacebookLink = "https://www.facebook.com/Ultimateqa1/";

    @Test
    public void verifySocialMediaButtonsLinkTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();

        complicatedPage.waitForComplicatedPageContent();
        Assert.assertTrue("Complicated page is not visible",
                complicatedPage.complicatedPageTitleElement.isDisplayed());

        List<String> twitterNavigationLinks = complicatedPage.getTwitterSocialMediaNavigationLinks();
        List<String> facebookNavigationLinks = complicatedPage.getFacebookSocialMediaNavigationLinks();

        Assert.assertEquals("Incorrect twitter links number",
                expectedSocialMediaLinksNumber, twitterNavigationLinks.size());

        twitterNavigationLinks.forEach(navigationLink ->
                Assert.assertEquals("Incorrect twitter navigation link",
                        expectedTwitterLink, navigationLink));

        Assert.assertEquals("Incorrect facebook links number",
                expectedSocialMediaLinksNumber, facebookNavigationLinks.size());

        facebookNavigationLinks.forEach(navigationLink -> Assert.assertEquals(
                "Incorrect facebook navigation link",
                expectedFacebookLink, navigationLink));
    }
}
