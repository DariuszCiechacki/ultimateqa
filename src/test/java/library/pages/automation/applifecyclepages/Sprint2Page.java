package library.pages.automation.applifecyclepages;

import library.modules.automation.applifecycle.AppLifecycleDto;
import library.modules.automation.applifecycle.forms.sprint2.Sprint2Form;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint2Page {
    public static final String sprint2PageTitle = "//h2[text() = 'Iteration 2']";

    public Sprint2Page waitForSprint2PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(sprint2PageTitle)));

        return this;
    }

    public void fillSprint2Form(AppLifecycleDto appLifecycleDto){
        new Sprint2Form()
                .enterFirstName(appLifecycleDto.getFirstName())
                .enterLastName(appLifecycleDto.getLastName());
    }

    public Sprint3Page navigateToSprint3Page(){
        driver.findElement(By.xpath("//a[contains(@href,'lifecycle-sprint-3')]"))
                .click();

        return new Sprint3Page();
    }
}
