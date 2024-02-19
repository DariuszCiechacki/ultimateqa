package tests.automation.simplehtmlelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

import static library.Driver.driver;

public class CompareHtmlTablesTest extends TestCase {
    @Test
    public void compareHtmlTablesTest() {
        HomePage homePage = new HomePage().waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
                        .isDisplayed());

        Map<String, Map<String, String>> uniqueTableData = simpleHtmlElementsPage.getUniqueIdTableData();
        Assert.assertEquals("Incorrect unique id table size",
                3, uniqueTableData.size());

        Map<String, Map<String, String>> noIdTableData = simpleHtmlElementsPage.getNoIdTableData();
        Assert.assertEquals("Incorrect no id table size",
                3, noIdTableData.size());

        Assert.assertEquals("Table are not identical",
                uniqueTableData, noIdTableData);
    }
}
