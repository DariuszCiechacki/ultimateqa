package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint4Page {

    public Sprint4Page waitForSprint4PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Iteration 4']")));

        return this;
    }

    public Sprint5Page navigateToSprint5Page(){
        driver.findElement(By.xpath("//a[contains(@href,'lifecycle-sprint-4')]"))
                .click();

        return new Sprint5Page();
    }
}
