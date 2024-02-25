package library.pages.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static drivers.Driver.driver;

public class FakeLandingPage {
    public static final String fakeLandingPageTitle = "//a[contains(@class,'et_pb_button et_pb_button_1')]";
    public static final String filePath = "src/test/java/library/files/availableCourses.txt";

    public FakeLandingPage waitForFakeLandingPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(fakeLandingPageTitle)));

        return this;
    }

    public Map<String, String> getAvailableCoursesData() {
        return driver.findElements(By.xpath("//div[contains(@class,'et_section_specialty')]//div[contains(@class,'et_pb_blurb_content')]"))
                .stream().collect(Collectors.toMap(
                        element -> element.findElement(By.xpath(".//h4[contains(@class,'et_pb_module_header')]"))
                                .getText(),
                        element -> element.findElement(By.xpath(".//div[contains(@class,'description')]"))
                                .getText(),
                        (existing, replacement) -> existing));
    }

    public void createTextFileWithAvailableCourses(Set<String> availableCoursesList) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (String courseName : availableCoursesList){
                writer.write(courseName);
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException exception){}
    }

    public void deleteCreatedFile(){

    }
}