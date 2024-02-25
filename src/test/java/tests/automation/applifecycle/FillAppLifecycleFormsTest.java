package tests.automation.applifecycle;

import library.TestCase;
import library.modules.automation.applifecycle.AppLifecycleFactory;
import library.pages.HomePage;
import library.pages.automation.applifecyclepages.Sprint1Page;
import library.pages.automation.applifecyclepages.Sprint2Page;
import library.pages.automation.applifecyclepages.Sprint3Page;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.applifecyclepages.Sprint1Page.sprint1PageTitle;
import static library.pages.automation.applifecyclepages.Sprint2Page.sprint2PageTitle;
import static library.pages.automation.applifecyclepages.Sprint3Page.sprint3PageTitle;

public class FillAppLifecycleFormsTest extends TestCase {

    @Test
    public void fillAppLifecycleFormsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        Sprint1Page sprint1Page = homePage.navigateToAppLifecyclePage();

        sprint1Page.waitForSprintOnePageContent();
        Assert.assertTrue("Sprint 1 page is not visible",
                driver.findElement(By.xpath(sprint1PageTitle))
                        .isDisplayed());

        sprint1Page.enterFirstName(AppLifecycleFactory.createAppLifecycleFormData());

        Sprint2Page sprint2Page = sprint1Page.navigateToSprint2Page();

        sprint2Page.waitForSprint2PageContent();
        Assert.assertTrue("Sprint 2 page is not visible",
                driver.findElement(By.xpath(sprint2PageTitle))
                        .isDisplayed());

        sprint2Page.fillSprint2Form(AppLifecycleFactory.createAppLifecycleFormData());

        Sprint3Page sprint3Page = sprint2Page.navigateToSprint3Page();

        sprint3Page.waitForSprint3PageContent();
        Assert.assertTrue("Sprint 3 page is not visible",
                driver.findElement(By.xpath(sprint3PageTitle))
                        .isDisplayed());

        sprint3Page.fillSprint3Form("other", AppLifecycleFactory.createAppLifecycleFormData());

        sprint3Page.submitForm();
    }
}
