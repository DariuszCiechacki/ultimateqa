package library.pages.automation.applifecyclepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint1Page {
    public Sprint1Page(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text() = 'Sprint 1']")
    public WebElement sprint1PageTitleElement;
    @FindBy(name = "firstname")
    public WebElement firstNameInput;
    @FindBy(xpath = "//a[contains(@href,'lifecycle-sprint-2')]")
    WebElement navigateToSprint2PageButton;

    public Sprint1Page waitForSprintOnePageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(sprint1PageTitleElement));

        return this;
    }

    public Sprint2Page navigateToSprint2Page(){
        navigateToSprint2PageButton.click();

        return new Sprint2Page();
    }
}
