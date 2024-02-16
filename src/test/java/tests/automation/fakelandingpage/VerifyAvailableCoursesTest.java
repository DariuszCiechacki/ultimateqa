package tests.automation.fakelandingpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

public class VerifyAvailableCoursesTest extends TestCase {

    @Test
    public void verifyAvailableCoursesTest(){
        driver.get(ConfigLoader.getProperty("baseUrl"));

        HomePage homePage = new HomePage(driver).waitForPageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();
        fakeLandingPage.waitForPageContent();

        Assert.assertTrue("Fake landing page is not visible",
                driver.findElement(By.xpath("//div[contains(@class,'et_section_specialty')]"))
                        .isDisplayed());

        Map<String, String> availableCourse = fakeLandingPage.getAvailableCoursesData();

        Assert.assertEquals("Incorrect number of available courses",
                "", "");
    }
}
