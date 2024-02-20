package library.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Driver.driver;

public class CollectionsPage {
    public static final String collectionsPageTitle = "//main[@class='collections']";

    public CollectionsPage waitForCollectionsPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(collectionsPageTitle)));

        return this;
    }
}
