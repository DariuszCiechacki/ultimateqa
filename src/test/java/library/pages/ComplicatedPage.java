package library.pages;

import library.BasePage;
import org.openqa.selenium.WebDriver;

public class ComplicatedPage extends BasePage {
    public ComplicatedPage(WebDriver driver) {
        super(driver);
    }

    public ComplicatedPage waitForPageContent(){

        return this;
    }
}
