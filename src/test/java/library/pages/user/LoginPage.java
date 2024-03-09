package library.pages.user;

import library.modules.automation.login.LoginInterface;
import library.pages.courses.CollectionsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class LoginPage implements LoginInterface {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class,'sign-in__container')]")
    public WebElement loginPageTitleElement;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@data-message='Signed in successfully.']")
    private WebElement loginMessageElement;

    public LoginPage waitForLoginPageContent() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .elementToBeClickable(loginPageTitleElement));

        return this;
    }

    @Override
    public CollectionsPage enterSignInCredentials(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        clickSubmitButton();

        return new CollectionsPage();
    }

    @Override
    public boolean isLoggedIn() {
        try {
            return loginMessageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void clickSubmitButton() {
        submitButton.click();
    }
}
