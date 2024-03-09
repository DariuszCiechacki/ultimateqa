package library.pages.automation.applifecyclepages;

import library.modules.automation.applifecycle.AppLifecycleDto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class Sprint2Page {
    public Sprint2Page(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text() = 'Iteration 2']")
    public WebElement sprint2PageTitleElement;
    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(xpath = "//a[contains(@href,'lifecycle-sprint-3')]")
    WebElement navigateToSprint3PageButton;

    public Sprint2Page waitForSprint2PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(sprint2PageTitleElement));

        return this;
    }

    public void fillSprint2Form(AppLifecycleDto appLifecycleDto){
        firstNameInput.sendKeys(appLifecycleDto.getFirstName());
        lastNameInput.sendKeys(appLifecycleDto.getLastName());
    }

    public Sprint3Page navigateToSprint3Page(){
        navigateToSprint3PageButton.click();

        return new Sprint3Page();
    }
}
