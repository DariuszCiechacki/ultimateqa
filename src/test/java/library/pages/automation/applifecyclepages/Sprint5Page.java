package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint5Page {
    public static final String sprint5PageTitle = "//h2[text() = 'Iteration 5']";

    public Sprint5Page waitForSprint5PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(sprint5PageTitle)));

        return this;
    }

    public SampleApplicationFormPage submitForm(){
        driver.findElement(By.xpath("//input[@value='Submit']"))
                .click();

        return new SampleApplicationFormPage();
    }
}
