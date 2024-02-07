package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.WebDriver;

public class SimpleHtmlElementsPage extends BasePage {
    public SimpleHtmlElementsPage(WebDriver driver) {
        super(driver);
    }

    public SimpleHtmlElementsPage waitForPageContent(){

        return this;
    }
}
