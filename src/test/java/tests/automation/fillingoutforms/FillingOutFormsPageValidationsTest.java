package tests.automation.fillingoutforms;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.modules.automation.fillingoutforms.FormsFactory;
import library.pages.HomePage;
import library.pages.automation.FillingOutFormsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.List;

public class FillingOutFormsPageValidationsTest extends TestCase {

    @Test
    public void fillingOutFormsPageValidationsTest(){
        driver.get(ConfigLoader.getProperty("baseUrl"));

        HomePage homePage = new HomePage(driver).waitForPageContent();

        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        FillingOutFormsPage fillingOutFormsPage = homePage.navigateToFillingOutFormsPage();
        fillingOutFormsPage.waitForPageContent();

        Assert.assertTrue("Filling out forms page is not visible",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0']"))
                        .isDisplayed());

        fillingOutFormsPage.clickSubmitButton(1);

        try{Thread.sleep(3000);}
        catch (Exception e){}

        Assert.assertTrue("Name field is not marked as required",
                driver.findElement(By.xpath("//input[@name='et_pb_contact_name_0' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertTrue("Message field is not marked as required",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0' and contains(@class, 'error')]"))
                .isDisplayed());

        fillingOutFormsPage.clickSubmitButton(2);

        try{Thread.sleep(3000);}
        catch (Exception e){}

        List<String> listOfRequiredFieldsForm1 = fillingOutFormsPage.getFieldsNamesWithError(1);

        Assert.assertEquals("Name field is missing in required fields list",
                "Name", listOfRequiredFieldsForm1.get(0));

        Assert.assertEquals("Message field is missing in required fields list",
                "Message", listOfRequiredFieldsForm1.get(1));

        Assert.assertTrue("Name field is not marked as required",
                driver.findElement(By.xpath("//input[@name='et_pb_contact_name_1' and contains(@class, 'error')]"))
                .isDisplayed());

        Assert.assertTrue("Message field is not marked as required",
                driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_1' and contains(@class, 'error')]"))
                .isDisplayed());


        Assert.assertTrue("Captcha field is not marked as required",
                driver.findElement(By.xpath("//input[contains(@name,'captcha_1') and contains(@class,'error')]"))
                        .isDisplayed());

        List<String> listOfRequiredFieldsForm2 = fillingOutFormsPage.getFieldsNamesWithError(2);
        Assert.assertEquals("Name field is missing in required fields list",
                "Name", listOfRequiredFieldsForm1.get(0));

        Assert.assertEquals("Message field is missing in required fields list",
                "Message", listOfRequiredFieldsForm1.get(1));

        Assert.assertEquals("Captcha field is missing in required fields list",
                "Captcha", listOfRequiredFieldsForm1.get(2));
    }
}