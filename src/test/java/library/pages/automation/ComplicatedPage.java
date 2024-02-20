package library.pages.automation;

import library.Driver;
import library.modules.automation.complicatedpage.SectionOfButtonsData;
import library.modules.automation.complicatedpage.SectionOfSocialMediaFollowsData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static library.Driver.driver;

public class ComplicatedPage {

    public ComplicatedPage waitForPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.id("Skills_Improved")));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons(){
        return new SectionOfButtonsData().countButtonsInSectionOfButtons();
    }

    public List<String> getButtonsText(){
        return new SectionOfButtonsData().getButtonsText();
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
