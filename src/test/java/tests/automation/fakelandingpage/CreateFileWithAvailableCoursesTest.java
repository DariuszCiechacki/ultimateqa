package tests.automation.fakelandingpage;

import library.TestCase;
import library.files.UniqueFilePathsFactory;
import library.pages.HomePage;
import library.pages.automation.FakeLandingPage;
import library.modules.common.adapters.FilesHandler;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class CreateFileWithAvailableCoursesTest extends TestCase {
    protected final String filePath = UniqueFilePathsFactory.generateAvailableCoursesFilePath();

    @Test
    public void createFileWithAvailableCoursesTest(){
        HomePage homePage = new HomePage().waitForHomePageContent();
        Assert.assertTrue("Home page is not visible",
                homePage.homePageTitleElement.isDisplayed());

        FakeLandingPage fakeLandingPage = homePage.navigateToFakeLandingPage();

        fakeLandingPage.waitForFakeLandingPageContent();
        Assert.assertTrue("Fake landing page is not visible",
                fakeLandingPage.fakeLandingPageTitleElement.isDisplayed());

        Map<String, String> availableCoursesMap = fakeLandingPage.getAvailableCoursesData();

        FilesHandler.createTextFileFromStringSet(
                availableCoursesMap.keySet(), filePath);

        Assert.assertTrue("File was not created successfully",
                FilesHandler.fileExists(filePath));

        Assert.assertTrue("File was not deleted successfully",
                FilesHandler.deleteCreatedFile(filePath));
    }
}
