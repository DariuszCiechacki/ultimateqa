package library.modules.automation.fillingoutforms;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsData extends BasePage {
    public FormsData(WebDriver driver) {
        super(driver);
    }

    public FormsData enterName(WebElement form, String name){
        form.findElement(By.xpath("//input[@data-original_id='name']"))
                .sendKeys(name);

        return this;
    }

    public FormsData enterMessage(WebElement form, String message){
        form.findElement(By.xpath("//textarea[@data-original_id='message']"))
                .sendKeys(message);

        return this;
    }
}
