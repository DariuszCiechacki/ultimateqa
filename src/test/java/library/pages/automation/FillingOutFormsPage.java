package library.pages.automation;

import library.modules.automation.fillingoutforms.FormNumber;
import library.modules.automation.fillingoutforms.FormsData;
import library.modules.automation.fillingoutforms.FormsDto;
import library.services.CaptchaHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static library.Driver.driver;

public class FillingOutFormsPage {
    public static final String fillingOutFormsTitle = "//textarea[@name='et_pb_contact_message_0']";

    public FillingOutFormsPage waitForFillingOutFormsPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath(fillingOutFormsTitle)));

        return this;
    }

    public FillingOutFormsPage fillFormByNumber(FormNumber formNumber, FormsDto formsDto) {
        int adjustedFormNumber = formNumber.getIndex();
        WebElement form = driver.findElement(
                By.xpath("//div[@id='et_pb_contact_form_"+adjustedFormNumber+"']"));

        new FormsData()
                .enterName(form, formsDto.getName())
                .enterMessage(form, formsDto.getMessage());

        handleCaptchaIfNecessary(form);
        submitForm(form);

        return this;
    }

    public FillingOutFormsPage clickSubmitButton(FormNumber formNumber){
        int adjustedFormNumber = formNumber.getIndex();
        WebElement form = driver.findElement(
                By.xpath("//div[@id='et_pb_contact_form_"+adjustedFormNumber+"']"));

        form.findElement(By.xpath(".//button[@name='et_builder_submit_button']"))
                .click();

        return this;
    }

    public List<String> getRequiredFieldsList(FormNumber formNumber) {
        int adjustedFormNumber = formNumber.getIndex();

        return driver.findElements(
                By.xpath("//div[@id='et_pb_contact_form_" + adjustedFormNumber + "']//div[contains(@class,'contact-message')]//li"))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private void handleCaptchaIfNecessary(WebElement form){
        try{
            WebElement captcha = form.findElement(By.xpath(".//input[contains(@name,'captcha')]"));
            if (captcha.isDisplayed()) {
                new CaptchaHandler().handleCaptcha(form);
            }
        }
        catch (Exception ignored){}
    }

    private void submitForm(WebElement form) {
        WebElement submitButton = form.findElement(By.xpath(".//button[@name='et_builder_submit_button']"));
        submitButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(submitButton));
    }
}
