package library.pages.automation;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ComplicatedPage extends Driver {
    public ComplicatedPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Skills_Improved")
    public WebElement complicatedPageTitleElement;
    @FindBy(xpath = "//div[contains(@class,'et_pb_button')]//a")
    public List<WebElement> buttonElement;
    @FindBy(xpath = "//div[contains(@class,'et_pb_row et_pb_row_4')]")
    public WebElement socialMediaButton;
    @FindBy(id = "A_toggle")
    WebElement toggleElement;
    @FindBy(xpath = "//div[contains(@class,'et_pb_toggle_content clearfix')]")
    WebElement toggleContentElement;

    public ComplicatedPage waitForComplicatedPageContent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(complicatedPageTitleElement));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons() {
        return buttonElement.size();
    }

    public List<String> getButtonsText() {
        return buttonElement.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyButtonsState() {
        if (buttonElement.isEmpty()) {
            return false;
        }

        return buttonElement.stream()
                .allMatch(WebElement::isEnabled);
    }

    //section of social media follows
    public List<String> getSocialMediaNavigationLinks(String socialMedia) {
        return driver.findElements(By.xpath(
                        socialMediaButton + "//li[contains(@class,'et-social-" + socialMedia + "')]//a")).stream()
                .map(WebElement -> WebElement.getAttribute("href")).collect(Collectors.toList());
    }

    public ComplicatedPage expandToggle() {
        toggleElement.click();

        waitForToggleToExpand();

        return this;
    }

    public String getToggleText() {
        return toggleContentElement.getText();
    }

    private void waitForToggleToExpand() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix') and contains(@style,'display: block')]")));
    }
}
