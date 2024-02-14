package library.pages.automation;

import library.BasePage;
import library.modules.automation.fillingoutforms.FormsData;
import library.modules.automation.fillingoutforms.FormsDto;
import library.services.CaptchaHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FillingOutFormsPage extends BasePage {
    public FillingOutFormsPage(WebDriver driver) {
        super(driver);
    }

    public FillingOutFormsPage waitForPageContent() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//textarea[@name='et_pb_contact_message_0']")));

        return this;
    }

    public FillingOutFormsPage fillForm(int formNumber, FormsDto formsDto) {
        int adjustedFormNumber = formNumber - 1;
        WebElement form = driver.findElement(
                By.xpath("//div[@id='et_pb_contact_form_"+adjustedFormNumber+"']"));

        new FormsData(driver)
                .enterName(form, formsDto.getName())
                .enterMessage(form, formsDto.getMessage());

        try{
            WebElement captcha = form.findElement(By.xpath(".//input[contains(@name,'captcha')]"));
            if (captcha.isDisplayed()) {
                new CaptchaHandler(driver).handleCaptcha(form);
            }
        }
        catch (Exception e){}

        clickSubmitButton(form);

        return this;
    }

    private void clickSubmitButton(WebElement form) {
        WebElement submitButton = form.findElement(By.xpath(".//button[@name='et_builder_submit_button']"));
        submitButton.click();

        wait.until(ExpectedConditions.invisibilityOf(submitButton));
    }
}
