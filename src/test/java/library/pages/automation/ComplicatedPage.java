package library.pages.automation;

import library.Driver;
import library.modules.automation.complicatedpage.SectionOfSocialMediaFollowsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ComplicatedPage extends Driver {
    public static final String complicatedPageTitle = "//span[@id='Skills_Improved']";
    public static final String buttonsXpath = "//div[contains(@class,'et_pb_row et_pb_row_2 et_pb_row_4col')]//a";

    public ComplicatedPage waitForComplicatedPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(complicatedPageTitle)));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons(){
        return driver.findElements(By.xpath(buttonsXpath)).size();
    }

    public List<String> getButtonsText(){
        return driver.findElements(By.xpath(buttonsXpath)).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Verifies that all buttons identified by the XPath in SectionOfButtonsData.buttonsXpath are enabled.
     *
     * @return true if all buttons are enabled, false otherwise.
     */
    public boolean verifyButtonsState() {
        List<WebElement> elements = driver.findElements(By.xpath(buttonsXpath));

        if (elements.isEmpty()) {
            //ToDo add throwing exception if list of elements is empty
            return false;
        }

        return elements.stream()
                .allMatch(WebElement::isEnabled);
    }

    //section of social media follows
    public List<String> getSocialMediaNavigationLinks(String socialMedia){
        return new SectionOfSocialMediaFollowsData()
                .getSocialMediaNavigationLinks(socialMedia);
    }

    public String getToggleText(){
        expandToggle();

        return driver.findElement(By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix')]"))
                .getText();
    }

    private void expandToggle(){
        driver.findElement(By.xpath("//span[@id='A_toggle']"))
                .click();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix') and contains(@style,'display: block')]")));

    }
}
