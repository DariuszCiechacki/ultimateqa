package library.pages.automation;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static library.Driver.driver;

public class FakeLandingPage {
    public static final String fakeLandingPageTitle = "//a[contains(@class,'et_pb_button et_pb_button_1')]";

    public FakeLandingPage waitForFakeLandingPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(fakeLandingPageTitle)));

        return this;
    }

    public Map<String, String> getAvailableCoursesData() {
        return driver.findElements(By.xpath("//div[contains(@class,'et_section_specialty')]//div[contains(@class,'et_pb_blurb_content')]"))
                .stream()
                .collect(Collectors.toMap(
                        element -> element.findElement(By.xpath(".//h4[contains(@class,'et_pb_module_header')]")).getText(),
                        element -> element.findElement(By.xpath(".//div[contains(@class,'description')]")).getText(),
                        (existing, replacement) -> existing)); // In case of duplicate keys, keep the existing entry
    }
}