package library.services;

import library.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CaptchaHandler {

    public void handleCaptcha(WebElement captchaContainer){
        WebElement captchaInput = captchaContainer.findElement(
                By.xpath(".//input[contains(@name,'et_pb_contact_captcha')]"));

        String firstDigit = captchaInput.getAttribute("data-first_digit");
        String secondDigit = captchaInput.getAttribute("data-second_digit");

        int result = Integer.parseInt(firstDigit) + Integer.parseInt(secondDigit);

        captchaInput.sendKeys(String.valueOf(result));
    }
}
