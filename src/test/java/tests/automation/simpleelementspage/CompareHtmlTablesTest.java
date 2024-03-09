package tests.automation.simpleelementspage;

import library.TestCase;
import library.modules.automation.simplepage.TableType;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.simpleelementspage.SimpleElementsPage.simpleElementsPageTitle;

public class CompareHtmlTablesTest extends TestCase {
    protected final int expectedTableSize = 3;

    @Test
    public void compareHtmlTablesTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleHtmlElementsPage = homePage.navigateSimpleElementsPage();

        simpleHtmlElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        Map<String, Map<String, String>> uniqueTableData = simpleHtmlElementsPage
                .getSpecificTableData(TableType.WITH_ID.tableType());

        Assert.assertEquals("Incorrect unique id table size",
                expectedTableSize, uniqueTableData.size());

        Map<String, Map<String, String>> noIdTableData = simpleHtmlElementsPage
                .getSpecificTableData(TableType.WITHOUT_ID.tableType());

        Assert.assertEquals("Incorrect no id table size",
                expectedTableSize, noIdTableData.size());

        Assert.assertEquals("Tables are not identical",
                uniqueTableData, noIdTableData);
    }
}
