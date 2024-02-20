package tests.user;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.courses.CollectionsPage;
import library.pages.user.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.courses.CollectionsPage.collectionsPageTitle;
import static library.pages.user.LoginPage.loginPageTitle;

public class LoginTest extends TestCase {

    @Test
    public void loginTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.waitForLoginPageContent();
        Assert.assertTrue("Login page is not visible",
                driver.findElement(By.xpath(loginPageTitle))
                        .isDisplayed());

        CollectionsPage collectionsPage = loginPage.enterSignInCredentials(
                ConfigLoader.getProperty("userEmail"),
                ConfigLoader.getProperty("userPassword"));

        collectionsPage.waitForCollectionsPageContent();
        Assert.assertTrue("Collections page is not visible",
                driver.findElement(By.xpath(collectionsPageTitle))
                        .isDisplayed());

        Assert.assertTrue("User was not logged in successfully",
                loginPage.isLoggedIn());
    }
}
