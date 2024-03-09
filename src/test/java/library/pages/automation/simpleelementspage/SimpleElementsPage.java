package library.pages.automation.simpleelementspage;

import library.modules.automation.simplepage.TablesSectionData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static drivers.Driver.driver;

public class SimpleElementsPage {
    public SimpleElementsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(text(),'simple HTML elements')]")
    public WebElement simpleElementsPageTitleElement;
    @FindBy(xpath = "//select")
    Select selectElement;
    @FindBy(id = "idExample")
    public WebElement byIdButton;
    @FindBy(xpath = "//a[text()='Click me using this link text!']")
    public WebElement byLinkTextButton;
    @FindBy(className = "buttonClass")
    public WebElement byClassNameButton;
    @FindBy(name = "button1")
    public WebElement byNameButton;
    @FindBy(xpath = "//span[contains(@class,'image_wrap')]//span")
    public WebElement byClickableIcon;

    public SimpleElementsPage waitForSimpleElementsPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                .elementToBeClickable(simpleElementsPageTitleElement));

        return this;
    }

    public Map<String, Map<String, String>> getSpecificTableData(WebElement table) {
        return new TablesSectionData().getTableData(table);
    }

    public void setRadiobutton(String value) {
        WebElement radiobutton = driver.findElement(By.xpath(
                "//input[@name='gender' and @value='" + value + "']"));

        radiobutton.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementSelectionStateToBe(radiobutton, true));
    }

    public void selectDropdownOption(String value) {
        selectElement.selectByVisibleText(value);
    }

    public String getSelectedOption(){
        return selectElement.getFirstSelectedOption().getText();
    }
}
