package tests.automation.fakelandingpage;

import library.TestCase;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Map;
import java.util.Set;

import static drivers.Driver.driver;
import static library.pages.HomePage.homePageTitle;
import static library.pages.automation.FakeLandingPage.fakeLandingPageTitle;

public class CreateFileWithAvailableCoursesTest extends TestCase {

    @Test
    public void createFileWithAvailableCoursesTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                driver.findElement(By.xpath(homePageTitle))
                        .isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();

        fakeLandingPage.waitForFakeLandingPageContent();
        Assert.assertTrue("Fake landing page is not visible",
                driver.findElement(By.xpath(fakeLandingPageTitle))
                        .isDisplayed());

        Map<String, String> availableCoursesMap = fakeLandingPage.getAvailableCoursesData();
        Set<String> availableCoursesList = availableCoursesMap.keySet();
        System.out.println(availableCoursesList);

    }
}
