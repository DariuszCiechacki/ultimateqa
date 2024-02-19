package library.pages.automation;

import library.Driver;
import library.modules.automation.fillingoutforms.FormsData;
import library.modules.automation.fillingoutforms.FormsDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FillingOutFormsPage extends Driver {

    public FillingOutFormsPage waitForPageContent() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//textarea[@name='et_pb_contact_message_0']")));

        return this;
    }

    public FillingOutFormsPage fillForm(int formNumber, FormsDto formsDto) {
        new FormsData().fillForm(formNumber, formsDto);

        return this;
    }

    public FillingOutFormsPage clickSubmitButton(int formNumber){
        int adjustedFormNumber = formNumber - 1;
        WebElement form = driver.findElement(
                By.xpath("//div[@id='et_pb_contact_form_"+adjustedFormNumber+"']"));

        form.findElement(By.xpath(".//button[@name='et_builder_submit_button']"))
                .click();

        return this;
    }

    public List<String> getRequiredFieldsList(int formNumber) {
        return new FormsData().getRequiredFieldsList(formNumber);
    }
}
