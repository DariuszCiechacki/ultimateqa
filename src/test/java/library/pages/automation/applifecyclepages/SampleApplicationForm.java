package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class SampleApplicationForm {
    public SampleApplicationForm waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Iteration 5']")));

        return this;
    }

    public SampleApplicationForm submitForm(){
        driver.findElement(By.xpath("//input[@value='Submit']"))
                .click();

        return new SampleApplicationForm();
    }
}
