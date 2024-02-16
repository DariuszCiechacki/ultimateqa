package library.pages.automation.simpleelementspage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonSuccessPage extends BasePage {

    public ButtonSuccessPage(WebDriver driver) {
        super(driver);
    }

    public ButtonSuccessPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='entry-title']")));

        return this;
    }
}
