package tests.user;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.courses.CollectionsPage;
import library.pages.user.LoginPage;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class LoginTest extends TestCase {

    @Test
    @Ignore("Disabled because of the captcha after submitting login")
    public void loginTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.waitForLoginPageContent();
        Assert.assertTrue("Login page is not visible",
                loginPage.loginPageTitleElement.isDisplayed());

        CollectionsPage collectionsPage = loginPage.enterSignInCredentials(
                ConfigLoader.getProperty("userEmail"),
                ConfigLoader.getProperty("userPassword"));

        collectionsPage.waitForCollectionsPageContent();
        Assert.assertTrue("Collections page is not visible",
                collectionsPage.collectionsPageTitleElement.isDisplayed());

        Assert.assertTrue("User was not logged in successfully",
                loginPage.isLoggedIn());
    }
}
