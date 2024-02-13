package library.pages.automation;

import library.BasePage;
import library.modules.automation.fillingoutforms.FormsData;
import library.modules.automation.fillingoutforms.FormsDto;
import library.services.CaptchaHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FillingOutFormsPage extends BasePage {
    public FillingOutFormsPage(WebDriver driver) {
        super(driver);
    }

    public FillingOutFormsPage waitForPageContent(){
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//textarea[@name='et_pb_contact_message_0']")));

        return this;
    }

    public FillingOutFormsPage fillAllForms(FormsDto formsDto){
        List<WebElement> forms = driver.findElements(
                By.xpath("//form[@class='et_pb_contact_form clearfix']"));

        forms.forEach(form -> {
            new FormsData(driver)
                    .enterName(form, formsDto.getName())
                    .enterMessage(form, formsDto.getMessage());

            if(form.findElement(By.xpath("//input[contains(@name,'captcha')]"))
                    .isDisplayed()){
                new CaptchaHandler(driver).handleCaptcha(form);
            }

            clickSubmitButton(form);
        });

        return this;
    }

    private void clickSubmitButton(WebElement form){
        form.findElement(By.xpath("//button[@name='et_builder_submit_button']"))
                .click();
    }
}
