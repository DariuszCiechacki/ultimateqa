package library.modules.automation.applifecycle;

import org.openqa.selenium.By;

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

    //ToDo change for finding and setting random radiobutton
    public AppLifecycleData setRadiobutton(String value){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+value+"']"))
                .click();

        return this;
    }
}
