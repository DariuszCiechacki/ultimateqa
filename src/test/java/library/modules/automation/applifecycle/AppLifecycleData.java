package library.modules.automation.applifecycle;

import org.openqa.selenium.By;

import static drivers.Driver.driver;

public class AppLifecycleData {
    public AppLifecycleData enterFirstName(String firstName){
        driver.findElement(By.xpath("//input[@name='firstname']"))
                .sendKeys(firstName);

        return this;
    }
}
