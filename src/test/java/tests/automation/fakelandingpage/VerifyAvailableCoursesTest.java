package tests.automation.fakelandingpage;

import com.ultimateqa.config.ConfigLoader;
import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

import static library.Driver.driver;

public class VerifyAvailableCoursesTest extends TestCase {
    protected int expectedNumberOfCourses = 8;
    protected String expectedCourseDescription = "Duis egestas aliquet aliquet. Maecenas erat eros, fringilla et leo eget, viverra pretium nulla.";

    @Test
    public void verifyAvailableCoursesTest(){
        HomePage homePage = new HomePage().waitForPageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.id("Automation_Practice"))
                        .isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();
        fakeLandingPage.waitForPageContent();

        Assert.assertTrue("Fake landing page is not visible",
                driver.findElement(By.xpath("//div[contains(@class,'et_section_specialty')]"))
                        .isDisplayed());

        Map<String, String> availableCourses = fakeLandingPage.getAvailableCoursesData();

        Assert.assertEquals("Incorrect number of available courses",
                expectedNumberOfCourses, availableCourses.size());

        availableCourses.forEach((key, value) -> Assert.assertEquals("Incorrect description of available course",
                expectedCourseDescription, value));
    }
}
