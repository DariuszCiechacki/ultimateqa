package library.pages.users;

import library.Driver;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Driver {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage waitForPageContent(){

        return this;
    }
}
