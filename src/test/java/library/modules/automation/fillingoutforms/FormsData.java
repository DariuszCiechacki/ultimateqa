package library.modules.automation.fillingoutforms;

import library.Driver;
import library.services.CaptchaHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static library.Driver.driver;

public class FormsData {
    public FormsData enterName(WebElement form, String name){
        form.findElement(By.xpath(".//input[@data-original_id='name']"))
                .sendKeys(name);

        return this;
    }

    public FormsData enterMessage(WebElement form, String message){
        form.findElement(By.xpath(".//textarea[@data-original_id='message']"))
                .sendKeys(message);

        return this;
    }
}
