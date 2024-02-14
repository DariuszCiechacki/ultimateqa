package tests.automation.fillingoutforms;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.modules.automation.fillingoutforms.FormsFactory;
import library.pages.HomePage;
import library.pages.automation.FillingOutFormsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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
    }
}
