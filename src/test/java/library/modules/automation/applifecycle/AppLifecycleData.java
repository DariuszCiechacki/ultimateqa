package library.modules.automation.applifecycle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static drivers.Driver.driver;

public class AppLifecycleData {
    public AppLifecycleData enterFirstName(String firstName){
        driver.findElement(By.xpath("//input[@name='firstname']"))
                .sendKeys(firstName);

        return this;
    }

    public AppLifecycleData enterLastName(String lastName){
        driver.findElement(By.xpath("//input[@name='lastname']"))
                .sendKeys(lastName);

        return this;
    }

    public AppLifecycleData setRandomRadiobutton(){
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[@name='gender']"));

        int randomIndex = new Random().nextInt(radioButtons.size());

        radioButtons.get(randomIndex).click();

        return this;
    }
}
