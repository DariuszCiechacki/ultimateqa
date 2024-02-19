package tests.automation.simplehtmlelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyCheckboxesTest extends TestCase {
    @Test
    public void verifyCheckboxesTest() {
        HomePage homePage = new HomePage().waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
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
