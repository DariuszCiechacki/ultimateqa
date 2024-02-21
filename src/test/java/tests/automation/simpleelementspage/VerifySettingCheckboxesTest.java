package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.simpleelementspage.SimpleElementsPage.simpleElementsPageTitle;

public class VerifySettingCheckboxesTest extends TestCase {

    @Test
    public void verifySettingCheckboxesTest() {
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();

        simpleHtmlElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        simpleHtmlElementsPage.setCheckbox(true, "Bike");
        simpleHtmlElementsPage.setCheckbox(false, "Car");

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                .isSelected());

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());

        simpleHtmlElementsPage.setCheckbox(true, "Bike", "Car");

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                        .isSelected());

        Assert.assertTrue("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());

        simpleHtmlElementsPage.setCheckbox(false, "Bike", "Car");

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Bike']"))
                        .isSelected());

        Assert.assertFalse("Incorrect checkbox selection",
                driver.findElement(By.xpath("//input[@name='vehicle' and @value='Car']"))
                        .isSelected());
    }
}
