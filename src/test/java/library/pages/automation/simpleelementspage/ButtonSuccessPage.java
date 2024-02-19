package library.pages.automation.simpleelementspage;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonSuccessPage extends Driver {

    public ButtonSuccessPage waitForPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='entry-title']")));

        return this;
    }
}
