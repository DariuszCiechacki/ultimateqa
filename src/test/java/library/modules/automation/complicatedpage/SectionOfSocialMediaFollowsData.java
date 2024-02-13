package library.modules.automation.complicatedpage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionOfSocialMediaFollowsData extends BasePage {
    public static String socialMediaButtonsSectionXpath = "//div[contains(@class,'et_pb_row et_pb_row_4')]";

    public SectionOfSocialMediaFollowsData(WebDriver driver) {
        super(driver);
    }

    public List<String> getSocialMediaNavigationLinks(String socialMedia){
        List<WebElement> socialMediaButtons = driver.findElements(By.xpath(
                socialMediaButtonsSectionXpath + "//li[contains(@class,'et-social-"+socialMedia+"')]//a"));

        List<String> navigationLinks = new ArrayList<>();

        socialMediaButtons.forEach(webElement -> {
            String navigationLink = webElement.getAttribute("href");
            navigationLinks.add(navigationLink);
        });

        return navigationLinks;
    }
}
