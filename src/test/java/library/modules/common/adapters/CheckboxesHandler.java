package library.modules.common.adapters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static drivers.Driver.driver;

public class CheckboxesHandler {
    public static void setCheckboxes(boolean state, String... values) {
        for (String value : values) {
            WebElement checkboxLabel = driver.findElement(By.xpath("//label[contains(@for,'checkbox') and text()='" + value + "']"));
            WebElement checkbox = checkboxLabel.findElement(By.xpath(".//preceding-sibling::input"));

            if (checkbox.isSelected() != state) {
                WebDriverActions.scrollToElementAndClick(checkboxLabel);
            }
        }
    }
}
