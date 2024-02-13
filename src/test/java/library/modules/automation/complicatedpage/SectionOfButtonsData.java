package library.modules.automation.complicatedpage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SectionOfButtonsData extends BasePage {
    public SectionOfButtonsData(WebDriver driver) {
        super(driver);
    }

    public int countButtonsInSectionOfButtons(){
        List<WebElement> buttons = driver.findElements(
                By.xpath("//div[contains(@class,'et_pb_row et_pb_row_2 et_pb_row_4col')]"));

        return buttons.size();
    }


}
