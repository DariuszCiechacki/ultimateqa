package library.pages.automation.simpleelementspage;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonSuccessPage extends Driver {

    public ButtonSuccessPage(WebDriver driver) {
        super(driver);
    }

    public ButtonSuccessPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='entry-title']")));

        return this;
    }
}
