package library.pages.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static library.Driver.driver;

public class FakeLandingPage {

    public FakeLandingPage waitForPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@class,'et_pb_button et_pb_button_1')]")));

        return this;
    }

    public Map<String, String> getAvailableCoursesData() {
        Map<String, String> availableCourses = new HashMap<>();

        List<WebElement> availableCoursesElements = driver.findElements(By.xpath(
                "//div[contains(@class,'et_section_specialty')]//div[contains(@class,'et_pb_blurb_content')]"));

        availableCoursesElements.forEach(element -> {
            String courseName = element.findElement(By.xpath(".//h4[contains(@class,'et_pb_module_header')]"))
                    .getText();
            String courseDescription = element.findElement(By.xpath(".//div[contains(@class,'description')]"))
                    .getText();

            availableCourses.put(courseName, courseDescription);
        });

        return availableCourses;
    }
}
