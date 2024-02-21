package tests.automation.simpleelementspage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.simpleelementspage.ButtonSuccessPage;
import library.pages.automation.simpleelementspage.SimpleElementsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.simpleelementspage.ButtonSuccessPage.buttonSuccessPageTitle;
import static library.pages.automation.simpleelementspage.SimpleElementsPage.simpleElementsPageTitle;

public class VerifyNavigationButtonsTest extends TestCase {

    @Test
    public void verifyNavigationButtonsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        SimpleElementsPage simpleElementsPage = homePage.navigateSimpleHtmlElementsPage();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        ButtonSuccessPage buttonSuccessPage = simpleElementsPage.navigateToButtonSuccessPage(
                "//a[@id='idExample']");

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath("//h1[@class='entry-title']"))
                        .isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        buttonSuccessPage = simpleElementsPage.navigateToButtonSuccessPage(
                "//a[@href='../link-success/']");

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath(buttonSuccessPageTitle))
                        .isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        buttonSuccessPage = simpleElementsPage.navigateToButtonSuccessPage(
                "//button[@class='buttonClass']");

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath(buttonSuccessPageTitle))
                        .isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        buttonSuccessPage = simpleElementsPage.navigateToButtonSuccessPage(
                "//button[@name='button1']");

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath(buttonSuccessPageTitle))
                        .isDisplayed());

        driver.navigate().back();

        simpleElementsPage.waitForSimpleElementsPageContent();
        Assert.assertTrue("Simple html elements page is not visible",
                driver.findElement(By.xpath(simpleElementsPageTitle))
                        .isDisplayed());

        buttonSuccessPage = simpleElementsPage.navigateToButtonSuccessPage(
                "//span[contains(@class,'et-pb-icon et-animated')]");

        buttonSuccessPage.waitForButtonSuccessPageContent();
        Assert.assertTrue("Button success page is not visible",
                driver.findElement(By.xpath(buttonSuccessPageTitle))
                        .isDisplayed());
    }
}