package library.pages.automation.simpleelementspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class ButtonSuccessPage {
    public ButtonSuccessPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='entry-title']")
    public WebElement buttonSuccessPageTitleElement;

    public ButtonSuccessPage waitForButtonSuccessPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .elementToBeClickable(buttonSuccessPageTitleElement));

        return this;
    }
}
