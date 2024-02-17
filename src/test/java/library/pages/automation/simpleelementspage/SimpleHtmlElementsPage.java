package library.pages.automation.simpleelementspage;

import library.BasePage;
import library.modules.automation.simplepage.CheckboxesSectionData;
import library.modules.automation.simplepage.TablesSectionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleHtmlElementsPage extends BasePage {
    public SimpleHtmlElementsPage(WebDriver driver) {
        super(driver);
    }

    public SimpleHtmlElementsPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idExample")));

        return this;
    }

    public ButtonSuccessPage navigateToButtonSuccessPage(String xPath){

        driver.findElement(By.xpath(xPath))
                .click();

        return new ButtonSuccessPage(driver);
    }

    public Map<String, Map<String, String>> getUniqueIdTableData(){
        return new TablesSectionData(driver).getUniqueIdTableData();
    }

    public Map<String, Map<String, String>> getNoIdTableData(){
        return new TablesSectionData(driver).getNoIdTableData();
    }

    public SimpleHtmlElementsPage fillCheckboxesSection(String radiobutton, String[] checkbox, boolean state, String selectValue){
        new CheckboxesSectionData(driver)
                .setRadiobutton(radiobutton)
                .setCheckbox(checkbox, state)
                .selectOption(selectValue);

        return this;
    }
}
