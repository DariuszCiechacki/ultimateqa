package library.pages.automation.applifecyclepages;

import library.modules.automation.applifecycle.AppLifecycleData;
import library.modules.automation.applifecycle.AppLifecycleDto;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint1Page {
    public static final String sprint1PageTitle = "//h2[text() = 'Sprint 1']";

    public Sprint1Page waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(sprint1PageTitle)));

        return this;
    }

    public void enterFirstName(AppLifecycleDto appLifecycleDto){
        new AppLifecycleData().enterFirstName(appLifecycleDto.getFirstName());
    }

    public Sprint2Page navigateToSprint2Page(){
        driver.findElement(By.xpath("//a[contains(@href,'lifecycle-sprint-2')]"))
                .click();

        return new Sprint2Page();
    }
}
