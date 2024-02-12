package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComplicatedPage extends BasePage {
    public ComplicatedPage(WebDriver driver) {
        super(driver);
    }

    public ComplicatedPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='Skills_Improved']")));

        return this;
    }
}
