package tests.user;

import library.TestCase;
import library.pages.HomePage;
import library.pages.courses.CollectionsPage;
import library.pages.user.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestCase {

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage().waitForPageContent();

        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.waitForPageContent();

        CollectionsPage collectionsPage = loginPage.login(
                "dareck93@gmail.com", "Password#123");
        collectionsPage.waitForPageContent();

        Assert.assertTrue("User was not logged in successfully",
                loginPage.isLoggedIn());
    }
}
