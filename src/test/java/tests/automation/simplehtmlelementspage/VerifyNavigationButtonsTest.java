package tests.automation.simplehtmlelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.ButtonSuccessPage;
import library.pages.automation.simpleelementspage.SimpleHtmlElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class VerifyNavigationButtonsTest extends TestCase {

    @Test
    public void verifyNavigationButtonsTest(){
        HomePage homePage = new HomePage().waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        SimpleHtmlElementsPage simpleHtmlElementsPage = homePage.navigateSimpleHtmlElementsPage();
        simpleHtmlElementsPage.waitForPageContent();

        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.id("idExample"))
                        .isDisplayed());

        ButtonSuccessPage buttonSuccessPage = simpleHtmlElementsPage.navigateToButtonSuccessPage(
                "//a[@id='idExample']");
        buttonSuccessPage.waitForPageContent();

        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());

        driver.navigate().back();
        simpleHtmlElementsPage.waitForPageContent();

        buttonSuccessPage = simpleHtmlElementsPage.navigateToButtonSuccessPage(
                "//a[@href='../link-success/']");
        buttonSuccessPage.waitForPageContent();

        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());

        driver.navigate().back();
        simpleHtmlElementsPage.waitForPageContent();

        buttonSuccessPage = simpleHtmlElementsPage.navigateToButtonSuccessPage(
                "//button[@class='buttonClass']");
        buttonSuccessPage.waitForPageContent();

        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());

        driver.navigate().back();
        simpleHtmlElementsPage.waitForPageContent();

        buttonSuccessPage = simpleHtmlElementsPage.navigateToButtonSuccessPage(
                "//button[@name='button1']");
        buttonSuccessPage.waitForPageContent();

        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());

        driver.navigate().back();
        simpleHtmlElementsPage.waitForPageContent();

        buttonSuccessPage = simpleHtmlElementsPage.navigateToButtonSuccessPage(
                "//span[contains(@class,'et-pb-icon et-animated')]");
        buttonSuccessPage.waitForPageContent();

        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());
    }
}