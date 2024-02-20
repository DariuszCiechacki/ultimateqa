package tests.automation.fillingoutforms;

import library.TestCase;
import library.modules.automation.fillingoutforms.FormNumber;
import library.modules.automation.fillingoutforms.FormsFactory;
import library.pages.HomePage;
import library.pages.automation.FillingOutFormsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.FillingOutFormsPage.fillingOutFormsTitle;

public class FillAllFormsTest extends TestCase {
    protected final String successMessage = "Thanks for contacting us";

    @Test
    public void fillAllFormsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        FillingOutFormsPage fillingOutFormsPage = homePage.navigateToFillingOutFormsPage();

        fillingOutFormsPage.waitForFillingOutFormsPageContent();
        Assert.assertTrue("Filling out forms page is not visible",
                driver.findElement(By.xpath(fillingOutFormsTitle))
                        .isDisplayed());

        fillingOutFormsPage.fillFormByNumber(FormNumber.FIRST_FORM, FormsFactory.createFormData());
        Assert.assertTrue("First form was not filled successfully",
                driver.findElement(By.xpath(
                        "//div[@id='et_pb_contact_form_0']//p[text()='"+successMessage+"']"))
                        .isDisplayed());

        fillingOutFormsPage.fillFormByNumber(FormNumber.SECOND_FORM, FormsFactory.createFormData());
        Assert.assertTrue("Second form was not filled successfully",
                driver.findElement(By.xpath(
                                "//div[@id='et_pb_contact_form_1']//p[text()='"+successMessage+"']"))
                        .isDisplayed());
    }
}
