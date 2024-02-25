package library.pages.automation.applifecyclepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint1Page {

    public Sprint1Page waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text() = 'Sprint 1']")));

        return this;
    }

    public Sprint2Page navigateToSprint2Page(){


        return new Sprint2Page();
    }
}
