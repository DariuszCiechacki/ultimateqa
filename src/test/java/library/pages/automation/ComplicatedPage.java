package library.pages.automation;

import drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ComplicatedPage extends Driver {
    public static final String complicatedPageTitle = "//span[@id='Skills_Improved']";
    public static final String buttonsXpath = "//div[contains(@class,'et_pb_button')]//a";
    public static final String socialMediaButtonsSectionXpath = "//div[contains(@class,'et_pb_row et_pb_row_4')]";

    public ComplicatedPage waitForComplicatedPageContent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(complicatedPageTitle)));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons() {
        return driver.findElements(By.xpath(buttonsXpath)).size();
    }

    public List<String> getButtonsText() {
        return driver.findElements(By.xpath(buttonsXpath)).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyButtonsState() {
        List<WebElement> elements = driver.findElements(By.xpath(buttonsXpath));

        if (elements.isEmpty()) {
            return false;
        }

        return elements.stream()
                .allMatch(WebElement::isEnabled);
    }

    //section of social media follows
    public List<String> getSocialMediaNavigationLinks(String socialMedia) {
        return driver.findElements(By.xpath(
                        socialMediaButtonsSectionXpath + "//li[contains(@class,'et-social-" + socialMedia + "')]//a")).stream()
                .map(WebElement -> WebElement.getAttribute("href")).collect(Collectors.toList());
    }

    public ComplicatedPage expandToggle() {
        driver.findElement(By.xpath("//span[@id='A_toggle']"))
                .click();

        waitForToggleToExpand();

        return this;
    }

    public String getToggleText() {
        return driver.findElement(By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix')]"))
                .getText();
    }

    private void waitForToggleToExpand() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix') and contains(@style,'display: block')]")));
    }
}
