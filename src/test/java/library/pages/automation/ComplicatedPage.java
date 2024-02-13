package library.pages.automation;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ComplicatedPage extends BasePage {
    public ComplicatedPage(WebDriver driver) {
        super(driver);
    }

    public ComplicatedPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Skills_Improved")));

        return this;
    }

    public int countButtonsInSectionOfButtons(){
        List<WebElement> buttons = driver.findElements(
                By.xpath("//div[contains(@class,'et_pb_row et_pb_row_2 et_pb_row_4col')]"));

        return buttons.size();
    }
}
