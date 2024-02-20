package library.pages.automation.simpleelementspage;

import library.modules.automation.simplepage.TablesSectionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static library.Driver.driver;

public class SimpleElementsPage {
    public static final String simpleElementsPageTitle = "//div[@id='idExample']";

    public SimpleElementsPage waitForSimpleElementsPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(simpleElementsPageTitle)));

        return this;
    }

    public Map<String, Map<String, String>> getUniqueIdTableData(){
        return new TablesSectionData().getUniqueIdTableData();
    }

    public Map<String, Map<String, String>> getNoIdTableData(){
        return new TablesSectionData().getNoIdTableData();
    }

    public void setCheckbox(boolean desiredState, String... checkboxes) {
        Arrays.stream(checkboxes).forEach(checkbox -> {
            WebElement checkboxField = driver.findElement(
                    By.xpath("//input[@name='vehicle' and @value='" + checkbox + "']"));

            if (checkboxField.isSelected() != desiredState) {
                checkboxField.click();
            }
        });
    }

    public void setRadiobutton(String radiobutton){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+radiobutton+"']"))
                .click();
    }

    public void selectDropdownOption(String value){
        Select select = new Select(driver.findElement(By.xpath("//select")));
        select.selectByValue(value);
    }

    public ButtonSuccessPage navigateToButtonSuccessPage(String xPath){
        driver.findElement(By.xpath(xPath))
                .click();

        return new ButtonSuccessPage();
    }
}
