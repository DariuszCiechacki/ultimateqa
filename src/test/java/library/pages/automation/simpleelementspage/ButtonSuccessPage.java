package library.pages.automation.simpleelementspage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Driver.driver;

public class ButtonSuccessPage {
    public static final String buttonSuccessPageTitle = "//h1[@class='entry-title']";

    public ButtonSuccessPage waitForButtonSuccessPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(buttonSuccessPageTitle)));

        return this;
    }
}
