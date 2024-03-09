package tests.automation.simpleelementspage;

import library.TestCase;
import library.modules.common.adapters.CheckboxesHandler;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;

public class VerifySettingCheckboxesTest extends TestCase {

    @Test
    public void verifySettingCheckboxesTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                simpleElementsPage.simpleElementsPageTitleElement.isDisplayed());

        CheckboxesHandler.setCheckboxes(true, "Bike");
        CheckboxesHandler.setCheckboxes(false, "Car");

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                .isSelected());

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());

        CheckboxesHandler.setCheckboxes(true, "Bike", "Car");

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                        .isSelected());

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());

        CheckboxesHandler.setCheckboxes(false, "Bike", "Car");

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                        .isSelected());

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());
    }
}
