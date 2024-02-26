package library.pages.automation.applifecyclepages;

import library.modules.automation.applifecycle.AppLifecycleDto;
import library.modules.automation.applifecycle.forms.sprint3.Sprint3Form;
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

    public void fillSprint3Form(AppLifecycleDto appLifecycleDto){
        new Sprint3Form()
                .setRandomRadiobutton()
                .enterFirstName(appLifecycleDto.getFirstName())
                .enterLastName(appLifecycleDto.getLastName());
    }

    public void submitForm(){
        driver.findElement(By.xpath("//input[@type='submit']"))
                .click();
    }
}
