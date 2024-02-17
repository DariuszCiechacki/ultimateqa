package library.modules.automation.simplepage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckboxesSectionData extends BasePage {
    public CheckboxesSectionData(WebDriver driver) {
        super(driver);
    }

    public CheckboxesSectionData setCheckbox(String[] checkboxes, boolean state){
        WebElement checkboxField = driver.findElement(By.xpath("//input[@name='vehicle' and @value='"+checkbox+"']"));
        boolean currentState = checkboxField.isSelected();

        if(currentState != state){
            checkboxField.click();
        }

        return this;
    }

    public CheckboxesSectionData setRadiobutton(String radiobutton){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+radiobutton+"']"))
                .click();

        return this;
    }

    public CheckboxesSectionData selectOption(String value){
        WebElement selectField = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(selectField);
        dropdown.selectByValue(value);

        return this;
    }
}
