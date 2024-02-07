package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.WebDriver;

public class FakeLandingPage extends BasePage {
    public FakeLandingPage(WebDriver driver) {
        super(driver);
    }

    public FakeLandingPage waitForPageContent(){

        return this;
    }
}
