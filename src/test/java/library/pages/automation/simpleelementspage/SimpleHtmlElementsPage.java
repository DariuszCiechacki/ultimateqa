package library.pages.automation.simpleelementspage;

import library.modules.automation.simplepage.TablesSectionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static library.Driver.driver;

public class SimpleHtmlElementsPage {

    public SimpleHtmlElementsPage waitForPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.id("idExample")));

        return this;
    }

    public ButtonSuccessPage navigateToButtonSuccessPage(String xPath){

        driver.findElement(By.xpath(xPath))
                .click();

        return new ButtonSuccessPage();
    }

    public Map<String, Map<String, String>> getUniqueIdTableData(){
        return new TablesSectionData().getUniqueIdTableData();
    }

    public Map<String, Map<String, String>> getNoIdTableData(){
        return new TablesSectionData().getNoIdTableData();
    }

    public SimpleHtmlElementsPage setCheckbox(boolean state, String... checkboxes){
        for (String checkbox : checkboxes){
            WebElement checkboxField = driver.findElement(By.xpath("//input[@name='vehicle' and @value='"+checkbox+"']"));
            boolean currentState = checkboxField.isSelected();

            if(currentState != state){
                checkboxField.click();
            }

        }
        return this;
    }

    public SimpleHtmlElementsPage setRadiobutton(String radiobutton){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+radiobutton+"']"))
                .click();

        return this;
    }

    public SimpleHtmlElementsPage selectOption(String value){
        WebElement selectField = driver.findElement(By.xpath("//select"));
        Select dropdown = new Select(selectField);
        dropdown.selectByValue(value);

        return this;
    }
}
