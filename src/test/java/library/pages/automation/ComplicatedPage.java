package library.pages.automation;

import library.Driver;
import library.modules.automation.complicatedpage.SectionOfButtonsData;
import library.modules.automation.complicatedpage.SectionOfSocialMediaFollowsData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class ComplicatedPage extends Driver {
    public static final String complicatedPageTitle = "//span[@id='Skills_Improved']";

    public ComplicatedPage waitForComplicatedPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(complicatedPageTitle)));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons(){
        return new SectionOfButtonsData().countButtonsInSectionOfButtons();
    }

    public List<String> getButtonsText(){
        return new SectionOfButtonsData().getButtonsText();
    }

    /**
     * Verifies that all buttons identified by the XPath in SectionOfButtonsData.buttonsXpath are enabled.
     *
     * @return true if all buttons are enabled, false otherwise.
     */
    public boolean verifyButtonsState() {
        List<WebElement> elements = driver.findElements(By.xpath(SectionOfButtonsData.buttonsXpath));

        if (elements.isEmpty()) {
            return false;
        }

        return elements.stream().allMatch(WebElement::isEnabled);
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
