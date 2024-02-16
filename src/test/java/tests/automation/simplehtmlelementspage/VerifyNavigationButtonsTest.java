package tests.automation.simplehtmlelementspage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.ComplicatedPage;
import library.pages.automation.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class VerifyNavigationButtonsTest extends TestCase {

    public void verifyNavigationButtonsTest(){
        driver.get(ConfigLoader.getProperty("baseUrl"));

        HomePage homePage = new HomePage(driver).waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
                        .isDisplayed());


    }
}
