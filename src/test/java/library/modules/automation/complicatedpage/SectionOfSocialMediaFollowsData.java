package library.modules.automation.complicatedpage;

import library.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionOfSocialMediaFollowsData extends BasePage {
    public static String socialMediaButtonsSectionXpath = "//div[contains(@class,'et_pb_row et_pb_row_4')]";
    protected static String twitterNavigationLink = "https://twitter.com/Nikolay_A00";
    protected static String facebookNavigationLink = "https://www.facebook.com/Ultimateqa1/";

    public SectionOfSocialMediaFollowsData(WebDriver driver) {
        super(driver);
    }

    public int verifySocialMediaNavigationLinks(String socialMedia, String expectedNavigationLink){
        List<WebElement> socialMediaButtons = driver.findElements(By.xpath(
                socialMediaButtonsSectionXpath + "//li[contains(@class,'et-social-"+socialMedia+"')]"));

        int navigationLinks = 0;

        for (WebElement element : socialMediaButtons) {
            String socialMediaNavigationLink = element.getAttribute("href");

            if (socialMediaNavigationLink.equals(expectedNavigationLink)) {
                navigationLinks++;
            }
        }

        return navigationLinks;
    }
}
