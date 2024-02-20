package tests.automation.fillingoutforms;

import library.TestCase;
import library.modules.automation.fillingoutforms.FormsFactory;
import library.pages.HomePage;
import library.pages.automation.FillingOutFormsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;

public class FillAllFormsTest extends TestCase {

    @Test
    public void fillAllFormsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        FillingOutFormsPage fillingOutFormsPage = homePage.navigateToFillingOutFormsPage();
        fillingOutFormsPage.waitForPageContent();

        Assert.assertTrue("Filling out forms page is not visible",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0']"))
                        .isDisplayed());

        fillingOutFormsPage.fillForm(1, FormsFactory.createFormData());
        Assert.assertTrue("First form was not filled successfully",
                driver.findElement(By.xpath(
                        "//div[@id='et_pb_contact_form_0']//p[text()='Thanks for contacting us']"))
                        .isDisplayed());

        fillingOutFormsPage.fillForm(2, FormsFactory.createFormData());
        Assert.assertTrue("Second form was not filled successfully",
                driver.findElement(By.xpath(
                                "//div[@id='et_pb_contact_form_1']//p[text()='Thanks for contacting us']"))
                        .isDisplayed());
    }
}
