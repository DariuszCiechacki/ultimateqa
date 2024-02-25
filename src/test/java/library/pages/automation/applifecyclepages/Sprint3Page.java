package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint3Page {

    public Sprint3Page waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Sprint 3']")));

        return this;
    }

    public Sprint4Page navigateToSprint4Page(){


        return new Sprint4Page();
    }
}
