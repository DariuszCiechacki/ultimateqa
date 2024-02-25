package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class SampleApplicationFormPage {
    public static final String sampleApplicationFormPageTitle = "//h2[text() = 'Iteration 5']";

    public SampleApplicationFormPage waitForSampleApplicationFormPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(sampleApplicationFormPageTitle)));

        return this;
    }

    public SampleApplicationFormPage submitForm(){
        driver.findElement(By.xpath("//input[@value='Submit']"))
                .click();

        return new SampleApplicationFormPage();
    }
}
