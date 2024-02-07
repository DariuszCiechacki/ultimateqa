package library.pages;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-main-menu")));

        return this;
    }


}
