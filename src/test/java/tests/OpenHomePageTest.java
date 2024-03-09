package tests;

import library.TestCase;
import library.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

public class OpenHomePageTest extends TestCase {
    @Test
    public void openPageTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());
    }
}
