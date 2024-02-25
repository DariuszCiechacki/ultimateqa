package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint4Page {

    public Sprint4Page waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Sprint 4']")));

        return this;
    }

    public Sprint5Page navigateToSprint5Page(){


        return new Sprint5Page();
    }
}
