package library.modules.automation.fillingoutforms;

import library.Driver;
import library.services.CaptchaHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FormsData extends Driver {
    public FormsData fillForm(int formNumber, FormsDto formsDto) {
        int adjustedFormNumber = formNumber - 1;
        WebElement form = driver.findElement(
                By.xpath("//div[@id='et_pb_contact_form_"+adjustedFormNumber+"']"));

        new FormsData()
                .enterName(form, formsDto.getName())
                .enterMessage(form, formsDto.getMessage());

        try{
            WebElement captcha = form.findElement(By.xpath(".//input[contains(@name,'captcha')]"));
            if (captcha.isDisplayed()) {
                new CaptchaHandler().handleCaptcha(form);
            }
        }
        catch (Exception e){}

        submitForm(form);

        return this;
    }

    public FormsData enterName(WebElement form, String name){
        form.findElement(By.xpath(".//input[@data-original_id='name']"))
                .sendKeys(name);

        return this;
    }

    public FormsData enterMessage(WebElement form, String message){
        form.findElement(By.xpath(".//textarea[@data-original_id='message']"))
                .sendKeys(message);

        return this;
    }

    public List<String> getRequiredFieldsList(int formNumber) {
        List<String> fieldsNamesWithError = new ArrayList<>();
        int adjustedFormNumber = formNumber - 1;
        List<WebElement> errorFieldsList = driver.findElements(
                By.xpath("//div[@id='et_pb_contact_form_" + adjustedFormNumber + "']//div[contains(@class,'contact-message')]//li"));

        for (WebElement element : errorFieldsList) {
            String errorFieldName = element.getText();
            fieldsNamesWithError.add(errorFieldName);
        }

        return fieldsNamesWithError;
    }

    private void submitForm(WebElement form) {
        WebElement submitButton = form.findElement(By.xpath(".//button[@name='et_builder_submit_button']"));
        submitButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(submitButton));
    }
}
