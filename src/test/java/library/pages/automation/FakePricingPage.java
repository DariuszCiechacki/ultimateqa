package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.WebDriver;

public class FakePricingPage extends BasePage {
    public FakePricingPage(WebDriver driver) {
        super(driver);
    }

    public FakePricingPage waitForPageContent(){

        return this;
    }
}
