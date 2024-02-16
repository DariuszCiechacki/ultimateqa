package library.modules.automation.complicatedpage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SectionOfButtonsData extends BasePage {
    public static String buttonsXpath = "//div[contains(@class,'et_pb_row et_pb_row_2 et_pb_row_4col')]//a";

    public SectionOfButtonsData(WebDriver driver) {
        super(driver);
    }

    public int countButtonsInSectionOfButtons(){
        List<WebElement> buttons = driver.findElements(By.xpath(buttonsXpath));

        return buttons.size();
    }

    public List<String> getButtonsText(){
        List<WebElement> buttons = driver.findElements(By.xpath(buttonsXpath));

        List<String> buttonsText = new ArrayList<>();

        buttons.forEach(element -> {
            String buttonText = element.getText();
            buttonsText.add(buttonText);
        });

        return buttonsText;
    }
}
