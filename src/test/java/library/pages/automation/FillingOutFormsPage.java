package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FillingOutFormsPage extends BasePage {
    public FillingOutFormsPage(WebDriver driver) {
        super(driver);
    }

    public FillingOutFormsPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//textarea[@name='et_pb_contact_message_0']")));

        return this;
    }
}
