package tests.automation.complicatedpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

import static library.Driver.driver;

public class VerifySocialMediaButtonsLinkTest extends TestCase {
    protected int expectedSocialMediaLinksNumber = 5;
    protected String expectedTwitterLink = "https://twitter.com/Nikolay_A00";
    protected String expectedFacebookLink = "https://www.facebook.com/Ultimateqa1/";

    @Test
    public void verifyNumberOfButtonsTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        ComplicatedPage complicatedPage = homePage.navigateToComplicatedPage();
        complicatedPage.waitForComplicatedPageContent();

        List<String> twitterNavigationLinks = complicatedPage.getSocialMediaNavigationLinks("twitter");
        List<String> facebookNavigationLinks = complicatedPage.getSocialMediaNavigationLinks("facebook");

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
