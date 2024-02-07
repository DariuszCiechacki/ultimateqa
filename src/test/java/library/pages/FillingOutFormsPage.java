package library.pages;

import library.BasePage;
import org.openqa.selenium.WebDriver;

public class FillingOutFormsPage extends BasePage {
    public FillingOutFormsPage(WebDriver driver) {
        super(driver);
    }

    public FillingOutFormsPage waitForPageContent(){

        return this;
    }
}
