package library.pages.automation.simpleelementspage;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Driver.driver;

public class ButtonSuccessPage {

    public ButtonSuccessPage waitForPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='entry-title']")));

        return this;
    }
}
