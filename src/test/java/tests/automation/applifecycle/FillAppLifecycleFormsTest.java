package tests.automation.applifecycle;

import library.TestCase;
import library.modules.automation.applifecycle.AppLifecycleFactory;
import library.pages.HomePage;
import library.pages.automation.applifecyclepages.Sprint1Page;
import library.pages.automation.applifecyclepages.Sprint2Page;
import library.pages.automation.applifecyclepages.Sprint3Page;
import org.junit.Assert;
import org.junit.Test;

public class FillAppLifecycleFormsTest extends TestCase {
    @Test
    public void fillAppLifecycleFormsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        Sprint1Page sprint1Page = homePage.navigateToAppLifecyclePage();

        sprint1Page.waitForSprintOnePageContent();
        Assert.assertTrue("Sprint 1 page is not visible",
                sprint1Page.sprint1PageTitleElement.isDisplayed());

        sprint1Page.firstNameInput.sendKeys(AppLifecycleFactory.createAppLifecycleFormData().getFirstName());

        Sprint2Page sprint2Page = sprint1Page.navigateToSprint2Page();

        sprint2Page.waitForSprint2PageContent();
        Assert.assertTrue("Sprint 2 page is not visible",
                sprint2Page.sprint2PageTitleElement.isDisplayed());

        sprint2Page.fillSprint2Form(AppLifecycleFactory.createAppLifecycleFormData());

        Sprint3Page sprint3Page = sprint2Page.navigateToSprint3Page();

        sprint3Page.waitForSprint3PageContent();
        Assert.assertTrue("Sprint 3 page is not visible",
                sprint3Page.sprint3PageTitleElement.isDisplayed());

        sprint3Page.fillSprint3Form(AppLifecycleFactory.createAppLifecycleFormData());

        sprint3Page.submitForm();
    }
}
