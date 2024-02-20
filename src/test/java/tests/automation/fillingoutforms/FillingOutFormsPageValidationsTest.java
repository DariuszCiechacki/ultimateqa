package tests.automation.fillingoutforms;

import library.TestCase;
import library.modules.automation.fillingoutforms.FormNumber;
import library.pages.HomePage;
import library.pages.automation.FillingOutFormsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.FillingOutFormsPage.fillingOutFormsTitle;

public class FillingOutFormsPageValidationsTest extends TestCase {

    //ToDo refactor assertions into one method with form number parameter
    @Test
    public void fillingOutFormsPageValidationsTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        FillingOutFormsPage fillingOutFormsPage = homePage.navigateToFillingOutFormsPage();

        fillingOutFormsPage.waitForFillingOutFormsPageContent();
        Assert.assertTrue("Filling out forms page is not visible",
                driver.findElement(By.xpath(fillingOutFormsTitle))
                        .isDisplayed());

        fillingOutFormsPage.clickSubmitButton(FormNumber.FIRST_FORM);

        List<String> listOfRequiredFieldsForm1 = fillingOutFormsPage.getRequiredFieldsList(FormNumber.FIRST_FORM);

        Assert.assertTrue("Name field is not marked as required",
                driver.findElement(By.xpath("//input[@name='et_pb_contact_name_0' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertTrue("Message field is not marked as required",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertEquals("Name field is missing in required fields list",
                "Name", listOfRequiredFieldsForm1.get(0));

        Assert.assertEquals("Message field is missing in required fields list",
                "Message", listOfRequiredFieldsForm1.get(1));

        fillingOutFormsPage.clickSubmitButton(FormNumber.SECOND_FORM);

        Assert.assertTrue("Name field is not marked as required",
                driver.findElement(By.xpath("//input[@name='et_pb_contact_name_1' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertTrue("Message field is not marked as required",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_1' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertTrue("Captcha field is not marked as required",
                driver.findElement(By.xpath("//input[contains(@name,'captcha_1') and contains(@class,'error')]"))
                        .isDisplayed());

        List<String> listOfRequiredFieldsForm2 = fillingOutFormsPage.getRequiredFieldsList(FormNumber.SECOND_FORM);
        Assert.assertEquals("Name field is missing in required fields list",
                "Name", listOfRequiredFieldsForm2.get(0));

        Assert.assertEquals("Message field is missing in required fields list",
                "Message", listOfRequiredFieldsForm2.get(1));

        Assert.assertEquals("Captcha field is missing in required fields list",
                "Captcha", listOfRequiredFieldsForm2.get(2));
    }
}
