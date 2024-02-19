package library.pages.user;

import library.modules.automation.login.LoginInterface;
import library.pages.courses.CollectionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static library.Driver.driver;

public class LoginPage implements LoginInterface {

    public LoginPage waitForPageContent(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='email']")));

        return this;
    }

    @Override
    public CollectionsPage login(String email, String password) {
        driver.findElement(By.xpath("//input[@type='email']"))
                .sendKeys(email);

        driver.findElement(By.xpath("//input[@type='password']"))
                .sendKeys(password);

        clickSubmitButton();

        return new CollectionsPage();
    }

    @Override
    public boolean isLoggedIn() {
        try {
            WebElement loginMessage = driver.findElement(
                    By.xpath("//div[@data-message='Signed in successfully.']"));
            return loginMessage.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    private void clickSubmitButton(){
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();
    }
}
