package library.pages.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class CollectionsPage {
    public CollectionsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[@class='collections__heading']")
    public WebElement collectionsPageTitleElement;

    public CollectionsPage waitForCollectionsPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .elementToBeClickable(collectionsPageTitleElement));

        return this;
    }
}
