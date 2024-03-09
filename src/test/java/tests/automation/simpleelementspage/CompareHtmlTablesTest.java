package tests.automation.simpleelementspage;

import library.TestCase;
import library.modules.automation.simplepage.TableType;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class CompareHtmlTablesTest extends TestCase {
    protected final int expectedTableSize = 3;

    @Test
    public void compareHtmlTablesTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        Map<String, Map<String, String>> uniqueTableData = simpleElementsPage
                .getSpecificTableData(TableType.WITH_ID.tableType());

        Assert.assertEquals("Incorrect unique id table size",
                expectedTableSize, uniqueTableData.size());

        Map<String, Map<String, String>> noIdTableData = simpleElementsPage
                .getSpecificTableData(TableType.WITHOUT_ID.tableType());

        Assert.assertEquals("Incorrect no id table size",
                expectedTableSize, noIdTableData.size());

        Assert.assertEquals("Tables are not identical",
                uniqueTableData, noIdTableData);
    }
}
