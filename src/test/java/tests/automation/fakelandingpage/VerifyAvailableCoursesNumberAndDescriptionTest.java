package tests.automation.fakelandingpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class VerifyAvailableCoursesNumberAndDescriptionTest extends TestCase {
    protected final int expectedNumberOfCourses = 8;
    protected final String expectedCourseDescription = "Duis egestas aliquet aliquet. Maecenas erat eros, fringilla et leo eget, viverra pretium nulla.";

    @Test
    public void verifyAvailableCoursesNumberAndDescriptionTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();

        fakeLandingPage.waitForFakeLandingPageContent();
        Assert.assertTrue("Fake landing page is not visible",
                fakeLandingPage.fakeLandingPageTitleElement.isDisplayed());

        Map<String, String> availableCourses = fakeLandingPage.getAvailableCoursesData();

        Assert.assertEquals("Incorrect number of available courses",
                expectedNumberOfCourses, availableCourses.size());

        availableCourses.forEach((key, value) -> Assert.assertEquals("Incorrect description of available course",
                expectedCourseDescription, value));
    }
}
