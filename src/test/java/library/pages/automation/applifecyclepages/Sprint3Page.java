package library.pages.automation.applifecyclepages;

import library.modules.automation.applifecycle.AppLifecycleDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static drivers.Driver.driver;

public class Sprint3Page {
    public Sprint3Page(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text() = 'Iteration 3']")
    public WebElement sprint3PageTitleElement;
    @FindBy(name = "firstname")
    WebElement firstNameInput;
    @FindBy(name = "lastname")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitFormButton;

    public Sprint3Page waitForSprint3PageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.elementToBeClickable(sprint3PageTitleElement));

        return this;
    }

    public void fillSprint3Form(AppLifecycleDto appLifecycleDto){
        setRandomRadiobutton();
        firstNameInput.sendKeys(appLifecycleDto.getFirstName());
        lastNameInput.sendKeys(appLifecycleDto.getLastName());
    }

    public void submitForm(){
        submitFormButton.click();
    }

    private void setRandomRadiobutton(){
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[@name='gender']"));

        int randomIndex = new Random().nextInt(radioButtons.size());

        radioButtons.get(randomIndex).click();
    }
}
