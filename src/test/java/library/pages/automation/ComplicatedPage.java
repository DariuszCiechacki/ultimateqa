package library.pages.automation;

import library.BasePage;
import library.modules.automation.complicatedpage.SectionOfButtonsData;
import library.modules.automation.complicatedpage.SectionOfSocialMediaFollowsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class ComplicatedPage extends BasePage {
    public ComplicatedPage(WebDriver driver) {
        super(driver);
    }

    public ComplicatedPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Skills_Improved")));

        return this;
    }

    //Section of buttons
    public int countButtonsInSectionOfButtons(){
        return new SectionOfButtonsData(driver).countButtonsInSectionOfButtons();
    }

    public List<String> getButtonsText(){
        return new SectionOfButtonsData(driver).getButtonsText();
    }

    //section of social media follows
    public List<String> getSocialMediaNavigationLinks(String socialMedia){
        return new SectionOfSocialMediaFollowsData(driver)
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

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'et_pb_toggle_content clearfix') and contains(@style,'display: block')]")));

    }
}
