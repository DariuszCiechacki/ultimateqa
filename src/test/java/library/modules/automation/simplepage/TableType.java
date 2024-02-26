package library.modules.automation.simplepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.Driver.driver;

public enum TableType {
    WITH_ID{
        public WebElement tableType(){
            return driver.findElement(By.xpath("//table[@id='htmlTableId']"));
        }
    },

    WITHOUT_ID{
        public WebElement tableType(){
            return driver.findElement(By.xpath("//table[not(@id='htmlTableId')]"));
        }
    };

    public abstract WebElement tableType();
}
