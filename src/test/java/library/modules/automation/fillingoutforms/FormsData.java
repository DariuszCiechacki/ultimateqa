package library.modules.automation.fillingoutforms;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsData extends BasePage {
    public FormsData(WebDriver driver) {
        super(driver);
    }

    public FormsData enterName(String name){
        driver.findElement(By.xpath("//input[@data-original_id='name']"))
                .sendKeys(name);

        return this;
    }

    public FormsData enterMessage(String message){
        driver.findElement(By.xpath("//textarea[@data-original_id='message']"))
                .sendKeys(message);

        return this;
    }
}
