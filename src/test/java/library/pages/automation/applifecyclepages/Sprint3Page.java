package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint3Page {
    public static final String sprint3PageTitle = "//h2[text() = 'Iteration 3']";

    public Sprint3Page waitForSprint3PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(sprint3PageTitle)));

        return this;
    }

    public Sprint4Page navigateToSprint4Page(){
        driver.findElement(By.xpath("//a[contains(@href,'lifecycle-sprint-4')]"))
                .click();

        return new Sprint4Page();
    }
}
