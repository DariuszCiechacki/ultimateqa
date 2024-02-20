package tests.automation.fakelandingpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;

import static library.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.FakeLandingPage.fakeLandingPageTitle;

public class VerifyAvailableCoursesNumberAndDescriptionTest extends TestCase {
    protected int expectedNumberOfCourses = 8;
    protected String expectedCourseDescription = "Duis egestas aliquet aliquet. Maecenas erat eros, fringilla et leo eget, viverra pretium nulla.";

    @Test
    public void verifyAvailableCoursesNumberAndDescriptionTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();

        fakeLandingPage.waitForFakeLandingPageContent();
        Assert.assertTrue("Fake landing page is not visible",
                driver.findElement(By.xpath(fakeLandingPageTitle))
                        .isDisplayed());

        Map<String, String> availableCourses = fakeLandingPage.getAvailableCoursesData();

        Assert.assertEquals("Incorrect number of available courses",
                expectedNumberOfCourses, availableCourses.size());

        availableCourses.forEach((key, value) -> Assert.assertEquals("Incorrect description of available course",
                expectedCourseDescription, value));
    }
}
