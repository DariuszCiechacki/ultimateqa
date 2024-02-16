package tests.automation.simplehtmlelementspage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

public class CompareHtmlTablesTest extends TestCase {
    @Test
    public void compareHtmlTablesTest() {
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

        Map<String, Map<String, String>> uniqueTableData = simpleHtmlElementsPage.getUniqueIdTableData();
        System.out.println(uniqueTableData);

        Assert.assertEquals("Incorrect table size",
                3, uniqueTableData.size());
    }
}
